# beacon-service
This service provides exact working hours spent by employee in office by checking the difference of beacon enabled mobile application comes in and out from range..

ENTRY ADD 

http://localhost:8080/beaconLog/add

Request :
{
	"userId" : "1001",
	"entryTime" : "2019-06-21 16:30",
	"eventType" : "ENTRY"
}

Response :
{
    "userId": "1001",
    "entryTime": "2019-06-21 16:30",
    "exitTime": null,
    "id": 5704568633556992,
    "eventType": "ENTRY"
}

-------------

EXIT ADD

http://localhost:8080/beaconLog/add

Request :
{
	"userId" : "1001",
	"entryTime" : "2019-06-21 16:30",
	"eventType" : "EXIT",
	"id" : 5704568633556992,
	"exitTime" : "2019-06-21 20:30"
}

Response :
{
    "userId": "1001",
    "entryTime": "2019-06-21 16:30",
    "exitTime": "2019-06-21 20:30",
    "id": 5704568633556992,
    "eventType": "ENTRY"
}


--------------
