package uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;

import uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.model.Parcel;

public class ParcelManager
{
	private static ParcelManager INSTANCE;
	private final HashSet<Parcel> parcels = new HashSet<>();
	private boolean modified;

	public static ParcelManager getInstance()
	{
		if (INSTANCE == null) {
			INSTANCE = new ParcelManager();
		}

		return INSTANCE;
	}

	private ParcelManager()
	{
		try (BufferedReader br = new BufferedReader(
				new FileReader("Parcels.csv")))
		{
			String input;
			br.readLine(); // 跳过标题行
			while ((input = br.readLine()) != null)
			{
				try {
					String[] temp = input.split(",");
					if (temp.length != 6) {
						System.err.println("Invalid data format: " + input);
						continue;
					}
					
					Parcel parcel = new Parcel();
					parcel.setParcelID(temp[0]);
					parcel.setDaysInDepot(Integer.parseInt(temp[1]));
					parcel.setWeight(Double.parseDouble(temp[2]));
					parcel.setWidth(Double.parseDouble(temp[3]));
					parcel.setLength(Double.parseDouble(temp[4]));
					parcel.setHeight(Double.parseDouble(temp[5]));
					
					parcels.add(parcel);
				} catch (NumberFormatException e) {
					System.err.println("Invalid number format in line: " + input);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean saveParcels()
	{
		try (BufferedWriter br = new BufferedWriter(
				new FileWriter("Parcels.csv")))
		{
			for (Parcel parcel : parcels)
			{
				br.write(parcel.getParcelID() + "," + parcel.getDaysInDepot()
						+ "," + parcel.getWeight() + "," + parcel.getLength()
						+ "," + parcel.getWidth() + "," + parcel.getHeight());
				br.newLine();
			}

			modified = false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return !modified;
	}

	public boolean addParcel(Parcel parcel)
	{
		boolean added = parcels.add(parcel);

		if (added) {
			modified = true;
		}

		return added;
	}

	public boolean deleteParcel(Parcel parcel)
	{
		boolean removed = parcels.remove(parcel);

		if (removed) {
			modified = true;
		}

		return removed;
	}

	public Parcel getParcel(String parcelID)
	{
		return parcels.stream().filter(p -> p.getParcelID().equals(parcelID))
				.findFirst().orElse(null);

		// Parcel parcel = null;
		//
		// for (Parcel p : parcels)
		// {
		// if (p.getParcelID().equals(parcelID))
		// {
		// parcel = p;
		// break;
		// }
		// }
		//
		// return parcel;
	}

	public List<Parcel> getParcels()
	{
		return List.copyOf(parcels);
	}

	// public void printParcels()
	// {
	// parcels.forEach(System.out::println);
	// }

	public boolean isModified()
	{
		return modified;
	}
}