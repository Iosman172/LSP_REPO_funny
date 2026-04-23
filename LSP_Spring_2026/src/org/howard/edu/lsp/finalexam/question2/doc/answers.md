# Design Explanation

The Template Method pattern is used in the abstract Report class through the generateReport() method. This method defines the fixed workflow for every report by calling loadData(), printHeader(), printBody(), and printFooter() in the same order. The steps are declared as abstract methods, so StudentReport and CourseReport can provide their own report-specific implementations. Since generateReport() is marked final, subclasses cannot change the overall algorithm, but they can customize the individual steps.
