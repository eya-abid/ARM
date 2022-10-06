Lab1 - The SOLID principles

Student Group: 

Eya Abid, Sarah Kamoun, Med Achraf Belkahla

Class: RT5 

Year: 2022-2023

Tasks: 
•	Understanding and Applying SOLID principles
•	Refactoring and UML modelling

1.	SRP (Single Responsibility Principle)

Principle Explanation: SRP states that a module/class should have only one responsibility or purpose.

Before: The class CarManager has many purposes. It is responsible for defining a list of cars (CarDatabase), extracting a car from the CarDatabase, getting a string version of CarDatabase and finding the best car amongst those within it.

After: The class CarManager should only have one responsibility, which is getting info about the Cars. All the details and process should be set in different classes, respecting the SRP rule.
	
Method of implementing the principle:  Class Car remains as it is, while Class CarManager’s tasks is split into different classes: Class TopCar finds the best car from a list of cars, Class CarList creates a String version of a list of cars, Class CarDB initializes the car database/list and extracts a car from the DB (equivalent of set/get). Class CarManager only gets all that information. 

Total Classes: Car, TopCar, CarList, CarDB, CarManager

2.	OCP (Open-Closed Principle)

Principle Explanation: “open to extension, closed to modification” Modules should be easily extensible without needing to alter the initial module. 

Before: ResourceAllocator is hard to extend with case-switch which make the extension of the class complicated. Modifying/Adding a new resource type would mean that we need to edit all functions. Similarly, many functions are specific to a certain type of resource, adding a new resource would mean more and more functions added (no concept of extensibility here).

After: ResourceAllocator should simply work with a resource, regardless of its type. That means it will allocate a resource or free a resource. Any other functions related to specific type of resource should be in its respective module/class. To insure extensibility, we also need the different types of resources to implement generic resource functions defined separately in another class. 

Method of implementing the principle: ResourceType shows us that there are 2 types of resources, TimeSlot and SpaceSlot. We create an interface Resource which has generic resource functions that the classes TimeSlot and SpaceSlot will implement. These two classes will override all the functions to match the resource type. The class RessourceAllocator allocates a resource of any type, so it needs to use the Interface Resource.

Total Modules: Class TimeSlot, Class SpaceSlot, Class RessouceAllocator, Interface Resource

3.	LSP (Liskov Substitution Principle)

Principle Explanation: LSP states that objects of a superclass should be replaceable with objects of its subclasses. Every method in the superclass should function in the same manner as the overridden methods. No new (unknown) exceptions should be thrown in derived class.

Before: ElectronicDuck throws a new exception that Duck doesn’t know about.  Pool shows that there’s “Duck” that has swim and quack methods and that DonaldDuck and ElectronicDuck are types of Ducks, so an interface is needed.

After: Ducks swim, quack, and have Duckexceptions that can be thrown by those function and that can be extended. DonaldDucks quack and swim. ElectronicDucks quack, swim, turn on and off, and have a specific type of Duck exceptions.

Method of implementing the principle: Create Interface Duck which DonaldDuck and ElectronicDuck implement. DuckIsOffException is part of ElectronicDuck and extends the Duckexception from Duck. Pool class edits to suit changes.

Total Modules: Duck Interface which has DuckException class (class = so it could be extended), DonaldDuck Class and ElectronicDuck Class (with the off-exception class), Pool class.

4.	ISP (Interface Segregation Principle) 
Principle Explanation: ISP states that modules should be separated in a way where all methods in each module are methods that its user(s) need.

Before: The interface Door has two methods that are specific to a certain type of user, meaning that they are useless for others. These methods are timeoutcallback (unneeded by SensingDoor) and proximityCallback (unneeded by TimedDoor). Moreover, these methods aren’t only related to Door objects, but rather any Sensing object or Timed object (respectively) may need to use these methods. 

After: Door should only have door related methods (lock, unlock, open, close). TimedDoor is both a Door and a TimedObject, just as SensingDoor is both a Door and a SensingObject. TimedObject has timeoutcallback, and SensingDoor has proximitycallback.

Method of implementing the principle: Door, SensingObject and TimedObject are all interfaces, while TimedDoor and SensingDoor implement them. The Sensor class would no longer use an instance of Door, but rather of SensingObject. Similarly, the Timer class registers a TimedObject instead.

Total Modules: Interfaces (SensingObject, TimedObject, Door), Classes (SensingDoor, TimedDoor,Timer, Sensor)


5.	DIP (Dependency Inversion Principle) 
Principle Explanation: Abstractions should not depend on details. High-level modules should not depend on low-level modules. Both should depend on abstractions.

Before: EncodingModuleClient,depends highly on the the EncodingModule , the filename for example of filereader and writer, as well as the url of the network reader. EncodingModule,has methods that highly depend on the reader and writer. We wouldn’t be able to tell what is causing the error if it happens.

After: There are two types of Readers, both which have a read method that throw IOException, as well as initializing method (instance of Reader), There are also two types of Writers, both which have the method write that also may throw an IOException, and an initializing method as well (instance of Writer). Any filename or url is set in the main method of the EncodingModuleClient.

Method of implementing the principle: We need an Interface Reader, which FileReader and NetworkReader implement. Similarly, Interface Writer is implemented by FileWriter and DatabaseWriter. Database class remains as is. EncodingModuleClient is edited to include the paths to the readers/writers. EncodingModule has the one task of encoding using a reader and writer.

Total Modules: Database Class, Interfaces (Writer, Reader) Classes (NetworkReader, FileWriter, DatabaseWriter, FileReader, Database, EncodingModule, EncodingModuleClient)
