# fst-api

## API Services

### **GET api/v1/artists**

Example:

```json
[
  {
    "id": 1,
    "name": "Above & Beyond",
    "performances": [
      {
        "id": 23,
        "performanceDay": "FRIDAY",
        "stages": "CIRCUIT_GROUNDS",
        "startTime": "19:39:00",
        "endtime": "16:41:00"
      }
     ]
  },
  {
    "id": 2,
    "name": "Alison Wonderland",
    "performances": [
       {
        "id": 1,
        "performanceDay": "FRIDAY",
        "stages": "KINETIC_FIELD",
        "startTime": "00:00:00",
        "endtime": "00:00:00"
       }
      ]
   }
 ]

Response: 200 OK
```

### **GET api/v1/artists/{id}**

```json
{
  "id": 1,
  "name": "Above & Beyond",
  "performances": [
    {
      "id": 23,
      "performanceDay": "FRIDAY",
      "stages": "CIRCUIT_GROUNDS",
      "startTime": "19:39:00",
      "endtime": "16:41:00"
    }
  ]
}

Response: 200 OK
```
