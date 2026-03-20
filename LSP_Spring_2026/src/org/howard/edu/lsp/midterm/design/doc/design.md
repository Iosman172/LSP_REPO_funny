CRC Card 1

Class: Order  
Responsibilities:
- Store order data such as customer name, email, item, and base price
- Provide controlled access to order information
- Represent the core domain object being processed

Collaborators:
- PricingService
- ReceiptPrinter
- OrderRepository
- NotificationService
- ActivityLogger
- OrderProcessor

-------------------

CRC Card 2

Class: OrderProcessor  
Responsibilities:
- Coordinate the overall order-processing workflow
- Request price calculation for an order
- Trigger receipt printing, order saving, notification, and logging
- Delegate work to specialized collaborators instead of doing everything itself

Collaborators:
- Order
- PricingService
- ReceiptPrinter
- OrderRepository
- NotificationService
- ActivityLogger

-------------------

CRC Card 3

Class: PricingService  
Responsibilities:
- Calculate tax for an order
- Apply discount rules
- Compute the final total
- Encapsulate pricing-related business logic

Collaborators:
- Order

-------------------

CRC Card 4
Class: ReceiptPrinter  
Responsibilities:
- Format and print a receipt for an order
- Display customer, item, and final total
- Handle presentation/output responsibilities related to receipts

Collaborators:
- Order

-------------------

CRC Card 5

Class: OrderRepository  
Responsibilities:
- Save processed order information
- Isolate file or storage logic from business logic
- Manage persistence of order records

Collaborators:
- Order

-------------------

CRC Card 6

Class: NotificationService  
Responsibilities:
- Send or simulate sending a confirmation message to the customer
- Isolate notification behavior from order-processing logic

Collaborators:
- Order

-------------------

CRC Card 7

Class: ActivityLogger  
Responsibilities:
- Log order-processing activity
- Record when processing occurs
- Isolate logging concerns from business logic

Collaborators:
- OrderProcessor