## Кратка документация към проекта  
Съдържа примерни заявки, както и резултат, към всички endpoint-ове на проекта.  

**Забележка.** Навсякъде, където не е споменато за body, то се счита за празно.  
  
    

1. Да се вземат всички линии сортирани по тип(тролей,трамвай и тн).  
```GET``` заявка към ```http://localhost:8080/line```   
Примерен резултат: 
```
[ {
  "id" : 9041,
  "number" : 11,
  "stopsCount" : 15,
  "distance" : 14.399999618530273,
  "type" : "bus"
}, {
  "id" : 9041,
  "number" : 11,
  "stopsCount" : 15,
  "distance" : 14.399999618530273,
  "type" : "bus"
}, {
  "id" : 9041,
  "number" : 11,
  "stopsCount" : 15,
  "distance" : 14.399999618530273,
  "type" : "bus"
}, {
  "id" : 1914,
  "number" : 204,
  "stopsCount" : 19,
  "distance" : 30.0,
  "type" : "metro"
}, {
  "id" : 2467,
  "number" : 20,
  "stopsCount" : 33,
  "distance" : 20.299999237060547,
  "type" : "metro"
}, {
  "id" : 8294,
  "number" : 120,
  "stopsCount" : 27,
  "distance" : 25.600000381469727,
  "type" : "tram"
}, {
  "id" : 8294,
  "number" : 120,
  "stopsCount" : 27,
  "distance" : 25.600000381469727,
  "type" : "tram"
}, {
  "id" : 1784,
  "number" : 604,
  "stopsCount" : 24,
  "distance" : 28.0,
  "type" : "trolleybus"
}, {
  "id" : 1784,
  "number" : 604,
  "stopsCount" : 24,
  "distance" : 28.0,
  "type" : "trolleybus"
} ]
```

2. По дадена линия да се вземат всички спирки от нея.  
```GET``` заявка към ```http://localhost:8080/line/{lineId}/stop```   
Примерна заяка към ```http://localhost:8080/line/1914/stop``` връща примерен резултат:  
```
[ {
  "id" : 614,
  "address" : "Sofia, Mladost 1",
  "longitude" : 15.982099533081055,
  "latitude" : 14.7253999710083,
  "canChargeCard" : true
}, {
  "id" : 1424,
  "address" : "Pliska",
  "longitude" : 15.762399673461914,
  "latitude" : 14.562199592590332,
  "canChargeCard" : true
}, {
  "id" : 6241,
  "address" : "Eagle Bridge",
  "longitude" : 15.622400283813477,
  "latitude" : 14.763099670410156,
  "canChargeCard" : true
} ]
```  

3. По линията и спирките да се извади разписание.  
```GET``` заявка към ```http://localhost:8080/schedule/{lineId}``` с body ```[stopId1, ..., stopIdn]```   
Примерна заявка към ```http://localhost:8080/schedule/1914``` с body ```[614, 1424]``` връща резултат  
```
TODO: add sample result
```

4. Вземане на всички Превозни Средства.  
```GET``` заявка към ```http://localhost:8080/vehicle```   
Примерен резултат:   
```
[ {
  "brand" : null,
  "model" : null,
  "plateNumber" : "CB2020HX",
  "seatCapacity" : 15,
  "standingCapacity" : 32,
  "hasAirConditioner" : false,
  "hasWheelchairRamp" : true,
  "type" : "bus",
  "lineId" : 9041
}, {
  "brand" : null,
  "model" : null,
  "plateNumber" : "CA1514CM",
  "seatCapacity" : 40,
  "standingCapacity" : 60,
  "hasAirConditioner" : true,
  "hasWheelchairRamp" : true,
  "type" : "bus",
  "lineId" : 9041
}, {
  "brand" : null,
  "model" : null,
  "plateNumber" : "CB1914HX",
  "seatCapacity" : 19,
  "standingCapacity" : 30,
  "hasAirConditioner" : false,
  "hasWheelchairRamp" : false,
  "type" : "bus",
  "lineId" : 9041
}, {
  "brand" : null,
  "model" : null,
  "plateNumber" : "CB9041KO",
  "seatCapacity" : 15,
  "standingCapacity" : 70,
  "hasAirConditioner" : true,
  "hasWheelchairRamp" : false,
  "type" : "tram",
  "lineId" : 8294
}, {
  "brand" : null,
  "model" : null,
  "plateNumber" : "CB0941EE",
  "seatCapacity" : 40,
  "standingCapacity" : 120,
  "hasAirConditioner" : true,
  "hasWheelchairRamp" : true,
  "type" : "tram",
  "lineId" : 8294
}, {
  "brand" : "Skoda",
  "model" : "450014",
  "plateNumber" : "CB5592HH",
  "seatCapacity" : 32,
  "standingCapacity" : 55,
  "hasAirConditioner" : true,
  "hasWheelchairRamp" : true,
  "type" : "trolleybus",
  "lineId" : 1784
}, {
  "brand" : "Skoda",
  "model" : "450015",
  "plateNumber" : "CB5992AA",
  "seatCapacity" : 38,
  "standingCapacity" : 75,
  "hasAirConditioner" : true,
  "hasWheelchairRamp" : true,
  "type" : "trolleybus",
  "lineId" : 1784
}, {
  "brand" : null,
  "model" : null,
  "plateNumber" : "940076  ",
  "seatCapacity" : 250,
  "standingCapacity" : 1500,
  "hasAirConditioner" : true,
  "hasWheelchairRamp" : false,
  "type" : "metro",
  "lineId" : 1914
}, {
  "brand" : null,
  "model" : null,
  "plateNumber" : "940077  ",
  "seatCapacity" : 250,
  "standingCapacity" : 1750,
  "hasAirConditioner" : true,
  "hasWheelchairRamp" : false,
  "type" : "metro",
  "lineId" : 2467
} ]
```   

5. Да се извадят имената на хората, които имат Карта за Линия.  
```GET``` заявка към ```http://localhost:8080/passenger```   
Примерен резултат:   
```
[ {
  "firstName" : "Georgi",
  "lastName" : "Stoilov"
}, {
  "firstName" : "Valentin",
  "lastName" : "Stoqnov"
}, {
  "firstName" : "Petar",
  "lastName" : "Terziev"
}, {
  "firstName" : "Ivaylo",
  "lastName" : "Arnaudov"
} ]  
```
