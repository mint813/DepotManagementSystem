# Depot Management System

## Project Overview

This is a warehouse parcel management system developed based on Java Swing, which is used to manage the parcel receiving, storage and customer pickup process. The system adopts the MVC architecture design and implements core functions such as parcel management, customer queues, and cost calculation.

### Business process
1. The site receives the customer's package
2. The staff records the package information in order
3. The customer arrives at the warehouse and uses the queuing system
4. The customer picks up the package and pays the fee
5. The system updates the package status

## System requirements

- JDK 17 or higher
- Maven 3.6 or higher
- Minimum memory requirement: 512MB
- Recommended memory: 1GB
- Disk space: 100MB

## Quick start

1. Clone the project

```bash
git clone https://github.com/your-repo/warehouse-parcel-management.git
cd warehouse-parcel-management
```

2. Compile the project

```bash
mvn clean compile
```

3. Run the project

```bash
mvn exec:java -Dexec.mainClass="uk.ac.herts.sp23ahy.mod_6com2013.asgnpart2.Main"
```

## Features

1. Package management
- Add new package (ID, size, weight, storage days)
- View package list (sorted by customer surname)
- Mark package collected
- Calculate storage fee
- Support management of at least 20 packages

2. Customer queue management
- Customer queuing system (FIFO principle)
- Sort alphabetically by surname
- Process the next customer
- Display the currently processed customer information

3. Fee calculation
- Basic fee: 5.0
- Weight fee: 0.5/kg
- Volume fee: 0.001/cm³
- Storage fee: 1.0/day

## System architecture

### MVC mode implementation

1. Model (model layer)
- Customer: customer information (name, package ID)
- Parcel: Parcel information (ID, size, weight, days)
- QueueOfCustomers: Customer queue management
- Log: Log record (singleton mode)

2. View (view layer)
- ParcelListFrame: Main window
- Parcel list display
- Customer queue display
- Currently processed parcel information
- AddParcelDialog: Add parcel dialog box

3. Controller (control layer)
- ParcelManager: Parcel data management
- CustomerManager: Customer data management
- Worker: Business logic processing (cost calculation, parcel processing)

## Data file

### CSV file format

1. Parcels.csv
```csv
ParcelID, DaysInDepot, Weight, Length, Width, Height
TEST001, 5, 10.0, 20.0, 15.0, 25.0
```

2. Custs.csv
```csv
CustomerName, ParcelID
John Smith,TEST001
```

## Testing

Running tests:

```bash
# Run all tests
mvn test

# Run specific tests
mvn test -Dtest=SystemFunctionalTest
```

### Test types
1. Unit testing
- ParcelTest: Package basic function test
- CustomerTest: Customer operation test
- WorkerTest: Business logic test

2. Integration testing
- SystemIntegrationTest: System integration test
- SystemFunctionalTest: Functional flow test
- BoundaryTest: Boundary condition test

## Troubleshooting

1. Program cannot start
- Check Java version (requires JDK 17+)
- Confirm that data files exist (Parcels.csv, Custs.csv)
- Verify file permissions (read and write permissions)

2. Data cannot be saved
- Check disk space
- Verify file write permissions
- Confirm that the file is not locked

## Development Guide

1. Code Standards
- Follow Java Coding Standards
- Add appropriate comments
- Keep code concise
- Use meaningful variable names

2. Submission Standards
- Clear submission information
- Single function submission
- Test before submission
- Keep code traceable

3. Use of design patterns
- Singleton pattern: Log class
- MVC pattern: Overall architecture
- Observer pattern: GUI update

## Version History

- v1.0.0 (2025-01)
- Initial version release
- Implement basic functions: package management, customer queue, fee calculation
- Complete GUI interface
- Implement data persistence

## License

This project uses the MIT license.

## Author

- Name: Wang Liule
- Student ID: 24048611
- Email: 2264571923@qq.com
- Course: 6COM2013-0901-2024 - Software Architecture
- Term: 2024-2025