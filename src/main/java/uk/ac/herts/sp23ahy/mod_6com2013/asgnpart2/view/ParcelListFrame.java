package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller.ParcelManager;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Customer;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Parcel;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.QueueOfCustomers;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller.Worker;
import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Log;

public class ParcelListFrame extends JFrame
// XXX: 1st Option: JFrame as listener
// implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private final ParcelManager parcelManager = ParcelManager.getInstance();
	private final JTable tblParcel = new JTable();
	private final JButton btnAdd = new JButton("Add Parcel"),
			btnMark = new JButton("Mark as Collected"),
			btnSave = new JButton("Save Report");
	private final QueueOfCustomers customerQueue = new QueueOfCustomers();
	private final Worker worker = new Worker();
	private final Log log = Log.getInstance();
	private final JPanel pnlQueue = new JPanel();
	private final JTable tblQueue = new JTable();
	private final JPanel pnlCurrentCustomer = new JPanel();
	private final JLabel lblCurrentCustomer = new JLabel();
	private final JLabel lblFee = new JLabel();

	public ParcelListFrame() throws Exception
	{
		super("Parcel List - Depot Management System");

		// 创建主面板，使用BorderLayout
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel pnlEast = new JPanel(new BorderLayout());

		// 按钮事件监听
		btnAdd.addActionListener(e -> add());
		btnMark.addActionListener(e -> mark());
		btnSave.addActionListener(e -> save());

		// 初始化表格
		tblParcel.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		display();

		// 添加按钮到南部面板
		pnlSouth.add(btnAdd);
		pnlSouth.add(btnMark);
		pnlSouth.add(btnSave);

		// 初始化队列和当前客户面板
		initializeQueuePanel();
		initializeCurrentCustomerPanel();

		// 将队列和当前客户面板添加到东部面板
		pnlEast.add(pnlQueue, BorderLayout.NORTH);
		pnlEast.add(pnlCurrentCustomer, BorderLayout.CENTER);
		pnlEast.setPreferredSize(new Dimension(300, 400));

		// 组装主面板
		mainPanel.add(new JScrollPane(tblParcel), BorderLayout.CENTER);
		mainPanel.add(pnlEast, BorderLayout.EAST);
		mainPanel.add(pnlSouth, BorderLayout.SOUTH);

		// 设置窗口
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void add()
	{
		new AddParcelDialog(this);
		display();
	}

	private void mark()
	{
		int row = tblParcel.getSelectedRow();

		if (row != -1)
		{
			String parcelID = (String) tblParcel.getModel().getValueAt(row, 0);

			if (parcelID != null)
			{
				Parcel parcel = parcelManager.getParcel(parcelID);

				if (parcel != null && JOptionPane.showConfirmDialog(this,
						"Are you sure want to mark this parcel as collected?",
						getTitle(),
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					if (parcelManager.deleteParcel(parcel))
					{
						JOptionPane.showMessageDialog(this,
								"Parcel " + parcel + " successfully collected.",
								getTitle(), JOptionPane.INFORMATION_MESSAGE);
						display();
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(this,
						"Unable to read the parcel ID.", getTitle(),
						JOptionPane.WARNING_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(this,
					"Please select a parcel to mark as collected.", getTitle(),
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void save()
	{
		if (parcelManager.saveParcels())
		{
			btnSave.setEnabled(false);
			JOptionPane.showMessageDialog(this,
					"Successfully saved the operations.", getTitle(),
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void display()
	{
		btnSave.setEnabled(parcelManager.isModified());
		tblParcel.setModel(new DefaultTableModel(
				parcelManager.getParcels().stream().map(parcel -> new String[] {
						parcel.getParcelID(),
						parcel.getDaysInDepot() + " day(s)",
						parcel.getWeight() + " kg(s)",
						parcel.getWidth() + " cm(s) x " + parcel.getHeight()
								+ " cm(s) x " + parcel.getLength() + " cm(s)"})
						.toArray(String[][]::new),
				new String[] {"Parcel ID", "Days in Depot", "Weight",
						"Dimension"}));

		updateQueueDisplay();
		updateCurrentCustomerDisplay();
	}

	private void processNextCustomer() {
		Customer customer = customerQueue.removeCustomer();
		if (customer != null) {
			worker.processCustomer(customer);
			updateQueueDisplay();
			updateCurrentCustomerDisplay();
			display();
		} else {
			JOptionPane.showMessageDialog(this,
				"No customers in queue",
				getTitle(),
				JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public void dispose() {
		log.saveToFile("depot_log.txt");
		super.dispose();
	}

	// XXX: 1st Option: JFrame as listener
	// @Override
	// public void actionPerformed(ActionEvent event)
	// {
	// if (event.getSource() == btnAdd)
	// System.out.println("Add button clicked");
	// else if (event.getSource() == btnMark)
	// System.out.println("Mark button clicked");
	// }

	// XXX: 2nd Option: Named inner class as listener
	// private class AddButtonListener implements ActionListener
	// {
	// @Override
	// public void actionPerformed(ActionEvent e)
	// {
	// System.out.println("Add button clicked");
	// }
	// }
	//
	// private class MarkButtonListener implements ActionListener
	// {
	// @Override
	// public void actionPerformed(ActionEvent e)
	// {
	// System.out.println("Mark button clicked");
	// }
	// }

	private void initializeQueuePanel() {
		pnlQueue.setBorder(BorderFactory.createTitledBorder("Customer Queue"));
		pnlQueue.setLayout(new BorderLayout());

		// 设置队列表格模型
		tblQueue.setModel(new DefaultTableModel(
			new String[][] {},
			new String[] {"Queue Position", "Customer Name", "Parcel ID"}
		));

		// 添加处理下一个客户的按钮
		JButton btnProcessNext = new JButton("Process Next Customer");
		btnProcessNext.addActionListener(e -> processNextCustomer());

		pnlQueue.add(new JScrollPane(tblQueue), BorderLayout.CENTER);
		pnlQueue.add(btnProcessNext, BorderLayout.SOUTH);
	}

	private void initializeCurrentCustomerPanel() {
		pnlCurrentCustomer.setBorder(BorderFactory.createTitledBorder("Current Customer"));
		pnlCurrentCustomer.setLayout(new GridLayout(4, 1, 5, 5));

		// 初始化标签
		lblCurrentCustomer.setText("No customer being processed");
		lblFee.setText("Fee: £0.00");

		// 添加组件
		pnlCurrentCustomer.add(lblCurrentCustomer);
		pnlCurrentCustomer.add(lblFee);
	}

	// 更新显示方法，包括队列显示
	private void updateQueueDisplay() {
		DefaultTableModel model = (DefaultTableModel) tblQueue.getModel();
		model.setRowCount(0); // 清除现有数据

		int position = 1;
		for (Customer customer : customerQueue.getQueue()) {
			model.addRow(new Object[] {
				position++,
				customer.toString(),
				customer.getParcel().getParcelID()
			});
		}
	}

	// 更新当前客户显示
	private void updateCurrentCustomerDisplay() {
		Customer current = worker.getCurrentCustomer();
		if (current != null) {
			lblCurrentCustomer.setText("Processing: " + current.toString());
			double fee = worker.calculateFee(current.getParcel());
			lblFee.setText(String.format("Fee: £%.2f", fee));
		} else {
			lblCurrentCustomer.setText("No customer being processed");
			lblFee.setText("Fee: £0.00");
		}
	}

	public static void main(String[] args) throws Exception
	{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new ParcelListFrame();
	}
}
