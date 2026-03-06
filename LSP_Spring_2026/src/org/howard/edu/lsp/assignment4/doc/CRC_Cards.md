**CRC CARD**



Class: AircraftBroadcastReceiver



Responsibilities:

* Receive transponder broadcasts from arriving aircraft.
* Validate packet format and signal integrity before further processing.
* Forward valid packets for decoding.
* Reject and report malformed or corrupt packets.



Collaborators (if any):

* FlightDataDecoder



Assumptions (if any):

* Aircraft broadcasts have enough packet structure to allow for basic validation before decoding.



\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_



**CRC CARD**



Class: FlightDataDecoder



Responsibilities:

* Unpack high-density transponder packets into structured flight data.
* Interpret packet fields such as aircraft type and flight information.
* Produce decoded aircraft data records for updating the system.
* Report decoding failures and invalid field values.



Collaborators (if any):

* AircraftBroadcastReceiver
* FlightTrackUpdater



Assumptions (if any):

* The transponder message format is known, allowing the system to decode packet fields into usable flight data.



\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_



**CRC CARD**



Class: FlightTrackUpdater



Responsibilities:

* Create a new aircraft track when an unknown aircraft appears.
* Update an existing aircraft track with newly decoded data.
* Merge incoming flight data into the current aircraft state.
* Mark tracks with updated timestamps.



Collaborators (if any):

* AircraftDatastore



Assumptions (if any):

* Each decoded packet includes an identifier so the aircraft can be linked to its track.



\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_



**CRC CARD**



Class: AircraftDatastore



Responsibilities:

* Store aircraft records and flight track data.
* Retrieve aircraft records by identifier.
* Provide aircraft data for display generation.
* Provide aircraft data for controller queries and danger analysis.



Collaborators (if any):

* FlightTrackUpdater
* RadarDisplayBuilder
* ConflictDetector
* ControllerQueryService



Assumptions (if any):

* This class represents the aircraft database.



\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_



**CRC CARD**



Class: DisplayUpdateScheduler



Responsibilities:

* Trigger graphics display updates every 10 seconds.
* Request current aircraft data for each refresh cycle.
* Coordinate regular refresh timing for the controller display.
* Detect and report missed refresh intervals.



Collaborators (if any):

* RadarDisplayBuilder
* AircraftDatastore



Assumptions (if any):

* The controller display must refresh at a fixed interval of 10 seconds.



\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_



**CRC CARD**



Class: RadarDisplayBuilder



Responsibilities:

* Build the controller’s graphics display from stored aircraft information.
* Convert aircraft records into screen display elements.
* Show aircraft positions and related flight details on screen.
* Add alert indicators for dangerous situations to displayed aircraft.



Collaborators (if any):

* AircraftDatastore
* AlertService



Assumptions (if any):

* The display uses aircraft data that is already stored in the system instead of relying on raw transponder broadcasts.



\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_



**CRC CARD**



Class: ConflictDetector



Responsibilities:

* Analyze aircraft information to detect dangerous situations.
* Compare aircraft track data against safety rules or thresholds.
* Identify aircraft involved in a detected hazard.
* Produce hazard results for alert handling and controller use.



Collaborators (if any):

* AircraftDatastore
* AlertService



Assumptions (if any):

* Dangerous situations are determined by predefined safety rules.



\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_



**CRC CARD**



Class: AlertService



Responsibilities:

* Receive hazard results from danger detection.
* Create active alerts for dangerous situations.
* Clear alerts when dangerous conditions no longer exist.
* Provide alert information to the display and controller query functions.



Collaborators (if any):

* ConflictDetector
* RadarDisplayBuilder
* ControllerQueryService



Assumptions (if any):

* The system must maintain active alerts over time.



\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_



**CRC CARD**



Class: ControllerQueryService



Responsibilities:

* Accept controller requests for details about a selected aircraft.
* Retrieve aircraft information for the requested plane.
* Retrieve active danger or alert information for that plane.
* Present detailed aircraft information to the controller.



* Collaborators (if any):
* AircraftDatastore
* AlertService
* RadarDisplayBuilder



Assumptions (if any):

* The controller selects a plane currently visible on the screen when making a query.



