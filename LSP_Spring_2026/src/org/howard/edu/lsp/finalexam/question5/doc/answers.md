Heuristic 1:
Name:
H3.2: Do not create god classes/objects in your system.

Explanation:
This heuristic improves maintainability because one class should not control too much of the system’s behavior. In lecture, this was illustrated with the home heating system example, where the HeatFlowRegulator became a “god class” because it pulled information from Room, made the main decision, and then controlled the Furnace. This makes the design harder to maintain because too much logic depends on one class. A better design distributes the responsibility so that Room determines whether it needs heat, and HeatFlowRegulator only coordinates the result.

Heuristic 2:
Name:
H3.3: Beware of classes that have many access methods defined in their public interface.

Explanation:
This heuristic improves readability and maintainability because too many get and set methods can show that related data and behavior are not being kept together. In lecture, this was shown through the HeatFlowRegulator using Room’s data, such as DesiredTemp, ActualTemp, and Occupancy, to make decisions. Instead of repeatedly exposing Room’s internal data through access methods, the improved design gives Room a method like do_I_need_heat(). This makes the code easier to understand because the behavior stays closer to the data it uses.

Heuristic 3:
Name:
H2.8: A class should capture one and only one key abstraction.

Explanation:
This heuristic improves readability and maintainability because each class should have one clear purpose. In lecture, the home heating system example helped show that Room should represent room-related information and behavior, while Furnace should represent something that can be turned on and off. If a class tries to represent multiple ideas or responsibilities, the design becomes harder to understand and change. Keeping each class focused on one key abstraction makes the system cleaner and easier to maintain.
