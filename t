[1mdiff --git a/resources/resortData/BigWhite/Bears Paw.json b/resources/resortData/BigWhite/Bears Paw.json[m
[1mindex c879147..e7d25ab 100644[m
[1m--- a/resources/resortData/BigWhite/Bears Paw.json[m	
[1m+++ b/resources/resortData/BigWhite/Bears Paw.json[m	
[36m@@ -1,9 +1,15 @@[m
 {[m
 	"resortCode" : "01",[m
     "roomNumberCode": "BP",[m
[31m-    "rooms": {[m
[31m-        "2 Bdrm Plus Den Premium w/Hot Tub" : [[m
[31m-            "07"[m
[31m-           ][m
[31m-    }[m
[32m+[m[32m//    "rooms": {[m
[32m+[m[32m//        "2 Bdrm Plus Den Premium w/Hot Tub" : [[m
[32m+[m[32m//            "07"[m
[32m+[m[32m//           ][m
[32m+[m[32m//    }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "701",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Den Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "07" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Black Bear Lodge.json b/resources/resortData/BigWhite/Black Bear Lodge.json[m
[1mindex ec380ba..06029b2 100644[m
[1m--- a/resources/resortData/BigWhite/Black Bear Lodge.json[m	
[1m+++ b/resources/resortData/BigWhite/Black Bear Lodge.json[m	
[36m@@ -1,15 +1,33 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "BL",[m
[31m-  "rooms": {[m
[31m-    "3 Bdrm Premium w/Hot Tub" : [[m
[31m-      "02",[m
[31m-      "03",[m
[31m-      "04",[m
[31m-      "07",[m
[31m-      "08",[m
[31m-      "10",[m
[31m-      "11"[m
[31m-    ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "3 Bdrm Premium w/Hot Tub" : [[m
[32m+[m[32m//      "02",[m
[32m+[m[32m//      "03",[m
[32m+[m[32m//      "04",[m
[32m+[m[32m//      "07",[m
[32m+[m[32m//      "08",[m
[32m+[m[32m//      "10",[m
[32m+[m[32m//      "11"[m
[32m+[m[32m//    ][m
[32m+[m[32m//  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "4834",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "10" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4833",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Premium w/Hot Tub",  //for 10[m
[32m+[m[32m    "roomNumbers" : [ "02" , "07" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4832",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "03" , "08" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "229",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "04" , "06" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Bullet Creek Cabins.json b/resources/resortData/BigWhite/Bullet Creek Cabins.json[m
[1mindex bd7636b..3f37c87 100644[m
[1m--- a/resources/resortData/BigWhite/Bullet Creek Cabins.json[m	
[1m+++ b/resources/resortData/BigWhite/Bullet Creek Cabins.json[m	
[36m@@ -1,20 +1,41 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "BC",[m
[31m-  "rooms": {[m
[31m-    "2 Bdrm Vacation Home w/Hot tub" : [[m
[31m-      "08",[m
[31m-      "09",[m
[31m-      "10",[m
[31m-      "11",[m
[31m-      "12"[m
[31m-    ],[m
[31m-    "3 Bdrm Vacation Home w/ Hot Tub" : [[m
[31m-      "13"[m
[31m-    ],[m
[31m-    "4 Bdrm Plus Den Vacation Home w/Hot Tub" : [[m
[31m-      "03",[m
[31m-      "16"[m
[31m-    ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "2 Bdrm Vacation Home w/Hot tub" : [[m
[32m+[m[32m//      "08",[m
[32m+[m[32m//      "09",[m
[32m+[m[32m//      "10",[m
[32m+[m[32m//      "11",[m
[32m+[m[32m//      "12"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "3 Bdrm Vacation Home w/ Hot Tub" : [[m
[32m+[m[32m//      "13"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "4 Bdrm Plus Den Vacation Home w/Hot Tub" : [[m
[32m+[m[32m//      "03",[m
[32m+[m[32m//      "16"[m
[32m+[m[32m//    ][m
[32m+[m[32m//  }[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "475",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Vacation Home w/Hot tub",[m
[32m+[m[32m    "roomNumbers" : [ "08", "09", "10", "12" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4826",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Vacation Home w/Hot tub",[m
[32m+[m[32m    "roomNumbers" : [ "11" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "3018",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Vacation Home w/ Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "13" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4825",[m
[32m+[m[32m    "roomDescription": "4 Bdrm Plus Den Vacation Home w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "03" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "429",[m
[32m+[m[32m    "roomDescription": "4 Bdrm Plus Den Vacation Home w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "16" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Chateau on the Ridge.json b/resources/resortData/BigWhite/Chateau on the Ridge.json[m
[1mindex e9e92cf..87e76f9 100644[m
[1m--- a/resources/resortData/BigWhite/Chateau on the Ridge.json[m	
[1m+++ b/resources/resortData/BigWhite/Chateau on the Ridge.json[m	
[36m@@ -1,13 +1,23 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "CH",[m
[31m-  "rooms": {[m
[31m-    "2 Bdrm Regular" : [[m
[31m-      "206",[m
[31m-      "310"[m
[31m-    ],[m
[31m-    "2 Bdrm Executive" : [[m
[31m-      "409"[m
[31m-    ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "2 Bdrm Regular" : [[m
[32m+[m[32m//      "206",[m
[32m+[m[32m//      "310"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "2 Bdrm Executive" : [[m
[32m+[m[32m//      "409"[m
[32m+[m[32m//    ][m
[32m+[m[32m//  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "230",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "206", "310" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "231",[m
[32m+[m[32m    "roomDescription": "3/4 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "409" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Copper Kettle Lodge.json b/resources/resortData/BigWhite/Copper Kettle Lodge.json[m
[1mindex 5028d37..a3dd52f 100644[m
[1m--- a/resources/resortData/BigWhite/Copper Kettle Lodge.json[m	
[1m+++ b/resources/resortData/BigWhite/Copper Kettle Lodge.json[m	
[36m@@ -1,29 +1,69 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "CK",[m
[31m-  "rooms": {[m
[31m-    "2 Bdrm Plus Den Premium w/Hot Tub" : [[m
[31m-      "108",[m
[31m-      "112",[m
[31m-      "204",[m
[31m-      "205",[m
[31m-      "207",[m
[31m-      "209",[m
[31m-      "210",[m
[31m-      "213",[m
[31m-      "310",[m
[31m-      "313"[m
[31m-    ],[m
[31m-    "3 Bdrm Plus Den Premium w/Hot Tub" : [[m
[31m-      "311"[m
[31m-    ],[m
[31m-    "3 Bdrm Premium w/Hot Tub" : [[m
[31m-      "114",[m
[31m-      "211",[m
[31m-      "214"[m
[31m-    ],[m
[31m-    "4 Bdrm Premium w/Hot Tub" : [[m
[31m-      "101"[m
[31m-    ][m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "2 Bdrm Plus Den Premium w/Hot Tub" : [[m
[32m+[m[32m//      "108",[m
[32m+[m[32m//      "112",[m
[32m+[m[32m//      "204",[m
[32m+[m[32m//      "205",[m
[32m+[m[32m//      "207",[m
[32m+[m[32m//      "209",[m
[32m+[m[32m//      "210",[m
[32m+[m[32m//      "213",[m
[32m+[m[32m//      "310",[m
[32m+[m[32m//      "313"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "3 Bdrm Plus Den Premium w/Hot Tub" : [[m
[32m+[m[32m//      "311"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "3 Bdrm Premium w/Hot Tub" : [[m
[32m+[m[32m//      "114",[m
[32m+[m[32m//      "211",[m
[32m+[m[32m//      "214"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "4 Bdrm Premium w/Hot Tub" : [[m
[32m+[m[32m//      "101"[m
[32m+[m[32m//    ][m
[32m+[m[32m//  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "899",[m
[32m+[m[32m    "roomDescription": "4 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "101" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "232",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Den Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "112" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "233",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "114" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4837",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Den Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "205" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4836",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Den Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "310" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4838",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Den Premium w/Hot Tub", //for 8[m
[32m+[m[32m    "roomNumbers" : [ "108", "204", "207", "313", "213" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4839",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Den Premium w/Hot Tub",  //for 9[m
[32m+[m[32m    "roomNumbers" : [ "209", "210" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "898",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Plus Den Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "311" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4835",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "211" , "214" ][m
   }[m
[32m+[m
[32m+[m[32m  ][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Eagles Resort.json b/resources/resortData/BigWhite/Eagles Resort.json[m
[1mindex 3edb99a..ee222ec 100644[m
[1m--- a/resources/resortData/BigWhite/Eagles Resort.json[m	
[1m+++ b/resources/resortData/BigWhite/Eagles Resort.json[m	
[36m@@ -1,13 +1,35 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "EG",[m
[31m-  "rooms": {[m
[31m-    "3/4 Bdrm Regular" : [[m
[31m-      "305",[m
[31m-      "308",[m
[31m-      "502",[m
[31m-      "505",[m
[31m-      "513"[m
[31m-      ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "3/4 Bdrm Regular" : [[m
[32m+[m[32m//      "305",[m
[32m+[m[32m//      "308",[m
[32m+[m[32m//      "502",[m
[32m+[m[32m//      "505",[m
[32m+[m[32m//      "513"[m
[32m+[m[32m//      ][m
[32m+[m[32m//  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "237",[m
[32m+[m[32m    "roomDescription": "3/4 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "305" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4611",[m
[32m+[m[32m    "roomDescription": "3/4 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "308" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4612",[m
[32m+[m[32m    "roomDescription": "3/4 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "502" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4613",[m
[32m+[m[32m    "roomDescription": "3/4 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "505" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4614",[m
[32m+[m[32m    "roomDescription": "3/4 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "513" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Grizzly Lodge.json b/resources/resortData/BigWhite/Grizzly Lodge.json[m
[1mindex faae9c2..a9e4087 100644[m
[1m--- a/resources/resortData/BigWhite/Grizzly Lodge.json[m	
[1m+++ b/resources/resortData/BigWhite/Grizzly Lodge.json[m	
[36m@@ -1,36 +1,78 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "GL",[m
[31m-  "rooms": {[m
[31m-    "1 Bdrm Plus Den Premium" : [[m
[31m-      "105",[m
[31m-      "204",[m
[31m-      "205",[m
[31m-      "305"[m
[31m-    ],[m
[31m-    "1 Bdrm Premium" : [[m
[31m-      "303"[m
[31m-    ],[m
[31m-    "1 Bdrm Premium w/Hot Tub" : [[m
[31m-      "203"[m
[31m-    ],[m
[31m-    "2 Bdrm Plus Den Premium" : [[m
[31m-      "302",[m
[31m-      "306"[m
[31m-    ],[m
[31m-    "2 Bdrm Plus Den Premium w/Hot Tub" : [[m
[31m-      "206"[m
[31m-    ],[m
[31m-    "2 Bdrm Premium" : [[m
[31m-      "307"[m
[31m-    ],[m
[31m-    "2 Bdrm Premium w/Hot Tub" : [[m
[31m-      "107",[m
[31m-      "207"[m
[31m-    ],[m
[31m-    "Studio Premium" : [[m
[31m-      "103",[m
[31m-      "106"[m
[31m-    ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "1 Bdrm Plus Den Premium" : [[m
[32m+[m[32m//      "105",[m
[32m+[m[32m//      "204",[m
[32m+[m[32m//      "205",[m
[32m+[m[32m//      "305"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "1 Bdrm Premium" : [[m
[32m+[m[32m//      "303"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "1 Bdrm Premium w/Hot Tub" : [[m
[32m+[m[32m//      "203"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "2 Bdrm Plus Den Premium" : [[m
[32m+[m[32m//      "302",[m
[32m+[m[32m//      "306"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "2 Bdrm Plus Den Premium w/Hot Tub" : [[m
[32m+[m[32m//      "206"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "2 Bdrm Premium" : [[m
[32m+[m[32m//      "307"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "2 Bdrm Premium w/Hot Tub" : [[m
[32m+[m[32m//      "107",[m
[32m+[m[32m//      "207"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "Studio Premium" : [[m
[32m+[m[32m//      "103",[m
[32m+[m[32m//      "106"[m
[32m+[m[32m//    ][m
[32m+[m[32m//  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "903",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "107" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "902",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "203" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "904",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Den Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "206" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4827",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "207" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "700",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Den Premium",[m
[32m+[m[32m    "roomNumbers" : [ "302" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "901",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Premium",[m
[32m+[m[32m    "roomNumbers" : [ "303" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4828",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Den Premium",[m
[32m+[m[32m    "roomNumbers" : [ "306" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "468",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Premium",[m
[32m+[m[32m    "roomNumbers" : [ "307" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "467",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Plus Den Premium",[m
[32m+[m[32m    "roomNumbers" : [ "105", "204", "205", "305" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "900",[m
[32m+[m[32m    "roomDescription": "Studio Premium",[m
[32m+[m[32m    "roomNumbers" : [ "103", "106" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Inn at Big White.json b/resources/resortData/BigWhite/Inn at Big White.json[m
[1mindex e83928f..24f636c 100644[m
[1m--- a/resources/resortData/BigWhite/Inn at Big White.json[m	
[1m+++ b/resources/resortData/BigWhite/Inn at Big White.json[m	
[36m@@ -1,4 +1,6 @@[m
 {[m
[32m+[m[32m  "resortCode" : "04",[m
[32m+[m[32m  "roomNumberCode" : "1BRH",[m
   "rooms": {[m
     "1 Bdrm Hotel IBW" : [[m
       "124",[m
[1mdiff --git a/resources/resortData/BigWhite/Plaza on the Ridge.json b/resources/resortData/BigWhite/Plaza on the Ridge.json[m
[1mindex 3c4495b..8d34ca0 100644[m
[1m--- a/resources/resortData/BigWhite/Plaza on the Ridge.json[m	
[1m+++ b/resources/resortData/BigWhite/Plaza on the Ridge.json[m	
[36m@@ -1,15 +1,33 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "PL",[m
[31m-  "rooms": {[m
[31m-    "2 Bdrm Regular" : [[m
[31m-      "334",[m
[31m-      "335",[m
[31m-      "449"[m
[31m-    ],[m
[31m-    "3/4 Bdrm Regular" : [[m
[31m-      "216",[m
[31m-      "322"[m
[31m-    ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "2 Bdrm Regular" : [[m
[32m+[m[32m//      "334",[m
[32m+[m[32m//      "335",[m
[32m+[m[32m//      "449"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "3/4 Bdrm Regular" : [[m
[32m+[m[32m//      "216",[m
[32m+[m[32m//      "322"[m
[32m+[m[32m//    ][m
[32m+[m[32m//  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "493",[m
[32m+[m[32m    "roomDescription": "3/4 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "216" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "906",[m
[32m+[m[32m    "roomDescription": "3/4 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "322" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "905",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "334" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4814",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "335", "449" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Ptarmigan Inn.json b/resources/resortData/BigWhite/Ptarmigan Inn.json[m
[1mindex ca46121..2d91023 100644[m
[1m--- a/resources/resortData/BigWhite/Ptarmigan Inn.json[m	
[1m+++ b/resources/resortData/BigWhite/Ptarmigan Inn.json[m	
[36m@@ -1,17 +1,35 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "PT",[m
[31m-  "rooms": {[m
[31m-    "1 Bdrm Regular" : [[m
[31m-      "107",[m
[31m-      "309",[m
[31m-      "315"[m
[31m-    ],[m
[31m-    "1 Bdrm Standard" : [[m
[31m-      "207"[m
[31m-    ],[m
[31m-    "2 Bdrm Standard" : [[m
[31m-      "204"[m
[31m-    ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "1 Bdrm Regular" : [[m
[32m+[m[32m//      "107",[m
[32m+[m[32m//      "309",[m
[32m+[m[32m//      "315"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "1 Bdrm Standard" : [[m
[32m+[m[32m//      "207"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "2 Bdrm Standard" : [[m
[32m+[m[32m//      "204"[m
[32m+[m[32m//    ][m
[32m+[m[32m//  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "908",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Standard",[m
[32m+[m[32m    "roomNumbers" : [ "204" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "907",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Standard",[m
[32m+[m[32m    "roomNumbers" : [ "207" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "854",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "315" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4815",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "107", "309" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Snowy Creek.json b/resources/resortData/BigWhite/Snowy Creek.json[m
[1mindex e092631..9c2395b 100644[m
[1m--- a/resources/resortData/BigWhite/Snowy Creek.json[m	
[1m+++ b/resources/resortData/BigWhite/Snowy Creek.json[m	
[36m@@ -1,13 +1,27 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "SN",[m
[31m-  "rooms": {[m
[31m-    "2 Bdrm Plus Den Premium w/Hot Tub" : [[m
[31m-      "04",[m
[31m-      "06"[m
[31m-    ],[m
[31m-    "3 Bdrm Plus Loft Premium w/Hot Tub" : [[m
[31m-      "10"[m
[31m-    ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m  //    "2 Bdrm Plus Den Premium w/Hot Tub" : [[m
[32m+[m[32m  //      "04",[m
[32m+[m[32m  //      "06"[m
[32m+[m[32m  //    ],[m
[32m+[m[32m  //    "3 Bdrm Plus Loft Premium w/Hot Tub" : [[m
[32m+[m[32m  //      "10"[m
[32m+[m[32m  //    ][m
[32m+[m[32m  //  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "909",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Den Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "04" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4812",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Den Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "06" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "738",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Plus Loft Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "09", "10" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Stonebridge Lodge.json b/resources/resortData/BigWhite/Stonebridge Lodge.json[m
[1mindex 48dd14e..14a7749 100644[m
[1m--- a/resources/resortData/BigWhite/Stonebridge Lodge.json[m	
[1m+++ b/resources/resortData/BigWhite/Stonebridge Lodge.json[m	
[36m@@ -2,75 +2,101 @@[m
     "resortCode" : "01",[m
     "propertyCode": "SB",[m
     "roomNumberCode": "SB",[m
[31m-    "rooms": {[m
[31m-        "1 Bdrm Executive w/Hot Tub (SB)" : [[m
[31m-            "1102",[m
[31m-            "1106",[m
[31m-            "1107",[m
[31m-            "1108",[m
[31m-            "1208",[m
[31m-            "1308",[m
[31m-            "1408"[m
[31m-        ],[m
[31m-        "2 Bdrm Executive" : [[m
[31m-            "1206",[m
[31m-            "2103",[m
[31m-            "2401"[m
[31m-        ],[m
[31m-        "2 Bdrm Executive w/Hot Tub (SB)" : [[m
[31m-            "1101",[m
[31m-            "1201",[m
[31m-            "1205",[m
[31m-            "1207",[m
[31m-            "1301",[m
[31m-            "1307",[m
[31m-            "1401",[m
[31m-            "1405",[m
[31m-            "1406",[m
[31m-            "1407",[m
[31m-            "2101",[m
[31m-            "2102",[m
[31m-            "2106",[m
[31m-            "2201",[m
[31m-            "2204",[m
[31m-            "2206",[m
[31m-            "2302",[m
[31m-            "2304",[m
[31m-            "2305",[m
[31m-            "2306",[m
[31m-            "3101",[m
[31m-            "3104",[m
[31m-            "3105",[m
[31m-            "3108",[m
[31m-            "3201",[m
[31m-            "3204",[m
[31m-            "3205",[m
[31m-            "3208",[m
[31m-            "3304",[m
[31m-            "3305",[m
[31m-            "3308"[m
[31m-        ],[m
[31m-        "2 Bdrm Plus Loft Executive w/Hot Tub (SB)" : [[m
[31m-            "2402",[m
[31m-            "2403",[m
[31m-            "2405",[m
[31m-            "2406"[m
[31m-        ],[m
[31m-        "3 Bdrm Executive w/Hot Tub (SB)" : [[m
[31m-            "1104",[m
[31m-            "1203",[m
[31m-            "1303",[m
[31m-            "1304",[m
[31m-            "1404",[m
[31m-            "3102",[m
[31m-            "3106",[m
[31m-            "3206",[m
[31m-            "3207",[m
[31m-            "3302",[m
[31m-            "3306"[m
[31m-        ],[m
[31m-        "3 Bdrm Plus Loft Executive w/Hot Tub (SB)" : [[m
[31m-            "3402"[m
[31m-        ][m
[31m-    } [m
[32m+[m[32m//    "rooms": {[m
[32m+[m[32m//        "1 Bdrm Executive w/Hot Tub (SB)" : [[m
[32m+[m[32m//            "1102",[m
[32m+[m[32m//            "1106",[m
[32m+[m[32m//            "1107",[m
[32m+[m[32m//            "1108",[m
[32m+[m[32m//            "1208",[m
[32m+[m[32m//            "1308",[m
[32m+[m[32m//            "1408"[m
[32m+[m[32m//        ],[m
[32m+[m[32m//        "2 Bdrm Executive" : [[m
[32m+[m[32m//            "1206",[m
[32m+[m[32m//            "2103",[m
[32m+[m[32m//            "2401"[m
[32m+[m[32m//        ],[m
[32m+[m[32m//        "2 Bdrm Executive w/Hot Tub (SB)" : [[m
[32m+[m[32m//            "1101",[m
[32m+[m[32m//            "1201",[m
[32m+[m[32m//            "1205",[m
[32m+[m[32m//            "1207",[m
[32m+[m[32m//            "1301",[m
[32m+[m[32m//            "1307",[m
[32m+[m[32m//            "1401",[m
[32m+[m[32m//            "1405",[m
[32m+[m[32m//            "1406",[m
[32m+[m[32m//            "1407",[m
[32m+[m[32m//            "2101",[m
[32m+[m[32m//            "2102",[m
[32m+[m[32m//            "2106",[m
[32m+[m[32m//            "2201",[m
[32m+[m[32m//            "2204",[m
[32m+[m[32m//            "2206",[m
[32m+[m[32m//            "2302",[m
[32m+[m[32m//            "2304",[m
[32m+[m[32m//            "2305",[m
[32m+[m[32m//            "2306",[m
[32m+[m[32m//            "3101",[m
[32m+[m[32m//            "3104",[m
[32m+[m[32m//            "3105",[m
[32m+[m[32m//            "3108",[m
[32m+[m[32m//            "3201",[m
[32m+[m[32m//            "3204",[m
[32m+[m[32m//            "3205",[m
[32m+[m[32m//            "3208",[m
[32m+[m[32m//            "3304",[m
[32m+[m[32m//            "3305",[m
[32m+[m[32m//            "3308"[m
[32m+[m[32m//        ],[m
[32m+[m[32m//        "2 Bdrm Plus Loft Executive w/Hot Tub (SB)" : [[m
[32m+[m[32m//            "2402",[m
[32m+[m[32m//            "2403",[m
[32m+[m[32m//            "2405",[m
[32m+[m[32m//            "2406"[m
[32m+[m[32m//        ],[m
[32m+[m[32m//        "3 Bdrm Executive w/Hot Tub (SB)" : [[m
[32m+[m[32m//            "1104",[m
[32m+[m[32m//            "1203",[m
[32m+[m[32m//            "1303",[m
[32m+[m[32m//            "1304",[m
[32m+[m[32m//            "1404",[m
[32m+[m[32m//            "3102",[m
[32m+[m[32m//            "3106",[m
[32m+[m[32m//            "3206",[m
[32m+[m[32m//            "3207",[m
[32m+[m[32m//            "3302",[m
[32m+[m[32m//            "3306"[m
[32m+[m[32m//        ],[m
[32m+[m[32m//        "3 Bdrm Plus Loft Executive w/Hot Tub (SB)" : [[m
[32m+[m[32m//            "3402"[m
[32m+[m[32m//        ][m
[32m+[m[32m//    }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "911",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Plus Loft Executive w/Hot Tub (SB)",[m
[32m+[m[32m    "roomNumbers" : [ "3402" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "318",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Executive w/Hot Tub (SB)",[m
[32m+[m[32m    "roomNumbers" : [ "1102", "1106", "1107", "1108", "1208", "1308", "1408" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "910",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Loft Executive w/Hot Tub (SB)",[m
[32m+[m[32m    "roomNumbers" : [ "2402", "2403", "2405", "2406" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "732",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Executive",[m
[32m+[m[32m    "roomNumbers" : [ "1206", "2103", "2401" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "319",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Executive w/Hot Tub (SB)",[m
[32m+[m[32m    "roomNumbers" : [ "1101", "1201", "1205", "1207", "1301", "1307", "1401", "1405", "1406", "1407", "2101", "2102", "2106", "2201", "2204", "2206", "2302", "2304", "2305", "2306", "3101", "3104", "3105", "3108", "3201", "3204", "3205", "3208", "3304", "3305", "3308"  ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "320",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Executive w/Hot Tub (SB)",[m
[32m+[m[32m    "roomNumbers" : [ "1104", "1203", "1303", "1304", "1404", "3102", "3106", "3206", "3207", "3302", "3306" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Stonegate Resort.json b/resources/resortData/BigWhite/Stonegate Resort.json[m
[1mindex abd11c5..83ec2c3 100644[m
[1m--- a/resources/resortData/BigWhite/Stonegate Resort.json[m	
[1m+++ b/resources/resortData/BigWhite/Stonegate Resort.json[m	
[36m@@ -2,54 +2,108 @@[m
     "resortCode" : "01",[m
     "propertyCode": "Sb",[m
     "roomNumberCode": "SG",[m
[31m-    "rooms": {[m
[31m-        "1 Bdrm Executive w/Hot Tub (SG)" : [[m
[31m-            "1102",[m
[31m-            "3102"[m
[31m-        ],[m
[31m-        "2 Bdrm Executive w/Hot Tub (SG)" : [[m
[31m-            "1101",[m
[31m-            "1103",[m
[31m-            "1202",[m
[31m-            "1205",[m
[31m-            "1302",[m
[31m-            "1305",[m
[31m-            "3101",[m
[31m-            "3103",[m
[31m-            "3105",[m
[31m-            "3202",[m
[31m-            "3302",[m
[31m-            "3402",[m
[31m-            "3405"[m
[31m-        ],[m
[31m-        "2 Bdrm Plus Loft Executive w/Hot Tub (SG)" : [[m
[31m-            "1402",[m
[31m-            "1405"[m
[31m-        ],[m
[31m-        "3 Bdrm Executive w/Hot Tub (SG)" : [[m
[31m-            "1104",[m
[31m-            "1106",[m
[31m-            "1201",[m
[31m-            "1203",[m
[31m-            "1204",[m
[31m-            "1206",[m
[31m-            "1303",[m
[31m-            "1304",[m
[31m-            "1306",[m
[31m-            "3201",[m
[31m-            "3203",[m
[31m-            "3301",[m
[31m-            "3303",[m
[31m-            "3304",[m
[31m-            "3306",[m
[31m-            "3403",[m
[31m-            "3406"[m
[31m-        ],[m
[31m-        "3 Bdrm Plus Loft Executive w/Hot Tub (SG)" : [[m
[31m-            "1401",[m
[31m-            "1403",[m
[31m-            "1404",[m
[31m-            "1406"[m
[31m-        ][m
[31m-    } [m
[32m+[m[32m//    "rooms": {[m
[32m+[m[32m//        "1 Bdrm Executive w/Hot Tub (SG)" : [[m
[32m+[m[32m//            "1102",[m
[32m+[m[32m//            "3102"[m
[32m+[m[32m//        ],[m
[32m+[m[32m//        "2 Bdrm Executive w/Hot Tub (SG)" : [[m
[32m+[m[32m//            "1101",[m
[32m+[m[32m//            "1103",[m
[32m+[m[32m//            "1202",[m
[32m+[m[32m//            "1205",[m
[32m+[m[32m//            "1302",[m
[32m+[m[32m//            "1305",[m
[32m+[m[32m//            "3101",[m
[32m+[m[32m//            "3103",[m
[32m+[m[32m//            "3105",[m
[32m+[m[32m//            "3202",[m
[32m+[m[32m//            "3302",[m
[32m+[m[32m//            "3402",[m
[32m+[m[32m//            "3405"[m
[32m+[m[32m//        ],[m
[32m+[m[32m//        "2 Bdrm Plus Loft Executive w/Hot Tub (SG)" : [[m
[32m+[m[32m//            "1402",[m
[32m+[m[32m//            "1405"[m
[32m+[m[32m//        ],[m
[32m+[m[32m//        "3 Bdrm Executive w/Hot Tub (SG)" : [[m
[32m+[m[32m//            "1104",[m
[32m+[m[32m//            "1106",[m
[32m+[m[32m//            "1201",[m
[32m+[m[32m//            "1203",[m
[32m+[m[32m//            "1204",[m
[32m+[m[32m//            "1206",[m
[32m+[m[32m//            "1303",[m
[32m+[m[32m//            "1304",[m
[32m+[m[32m//            "1306",[m
[32m+[m[32m//            "3201",[m
[32m+[m[32m//            "3203",[m
[32m+[m[32m//            "3301",[m
[32m+[m[32m//            "3303",[m
[32m+[m[32m//            "3304",[m
[32m+[m[32m//            "3306",[m
[32m+[m[32m//            "3403",[m
[32m+[m[32m//            "3406"[m
[32m+[m[32m//        ],[m
[32m+[m[32m//        "3 Bdrm Plus Loft Executive w/Hot Tub (SG)" : [[m
[32m+[m[32m//            "1401",[m
[32m+[m[32m//            "1403",[m
[32m+[m[32m//            "1404",[m
[32m+[m[32m//            "1406"[m
[32m+[m[32m//        ][m
[32m+[m[32m//    }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "4860",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Executive w/Hot Tub (SG)",[m
[32m+[m[32m    "roomNumbers" : [ "1302" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4859",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Executive w/Hot Tub (SG)",[m
[32m+[m[32m    "roomNumbers" : [ "3405" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "913",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Executive w/Hot Tub (SG)",[m
[32m+[m[32m    "roomNumbers" : [ "1102", "3102" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "914",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Loft Executive w/Hot Tub (SG)",[m
[32m+[m[32m    "roomNumbers" : [ "1402", "1405" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4858",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Executive w/Hot Tub (SG)",  //for 5[m
[32m+[m[32m    "roomNumbers" : [ "1202", "1305", "3105", "3202", "3402" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "325",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Executive w/Hot Tub (SG)",[m
[32m+[m[32m    "roomNumbers" : [ "1101", "1103", "1205", "3101", "3103" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4865",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Plus Loft Executive w/Hot Tub (SG)", //for 10[m
[32m+[m[32m    "roomNumbers" : [ "1404", "1406" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "695",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Plus Loft Executive w/Hot Tub (SG)",[m
[32m+[m[32m    "roomNumbers" : [ "1401", "1403" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "327",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Executive w/Hot Tub (SG)",  //for 10[m
[32m+[m[32m    "roomNumbers" : [ "3304", "3406" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4864",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Executive w/Hot Tub (SG)",  //for 6[m
[32m+[m[32m    "roomNumbers" : [ "1104", "1201", "1303" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4863",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Executive w/Hot Tub (SG)",[m
[32m+[m[32m    "roomNumbers" : [ "1203", "3201", "3203", "3301", "3303", "3403"][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4862",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Executive w/Hot Tub (SG)",[m
[32m+[m[32m    "roomNumbers" : [ "1106", "1204", "1304", "1306" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4861",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Executive w/Hot Tub (SG)",[m
[32m+[m[32m    "roomNumbers" : [ "1206", "3306" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Sundance Resort.json b/resources/resortData/BigWhite/Sundance Resort.json[m
[1mindex 7a01e44..ce7cce7 100644[m
[1m--- a/resources/resortData/BigWhite/Sundance Resort.json[m	
[1m+++ b/resources/resortData/BigWhite/Sundance Resort.json[m	
[36m@@ -1,100 +1,142 @@[m
 {[m
   "resortCode" : "05",[m
   "roomNumberCode" : "",[m
[31m-  "rooms": {[m
[31m-    "1 Bdrm Club Suite" : [[m
[31m-      "106",[m
[31m-      "121",[m
[31m-      "122",[m
[31m-      "123",[m
[31m-      "127",[m
[31m-      "128",[m
[31m-      "202",[m
[31m-      "203",[m
[31m-      "207",[m
[31m-      "220",[m
[31m-      "227",[m
[31m-      "303",[m
[31m-      "306",[m
[31m-      "323",[m
[31m-      "326",[m
[31m-      "327",[m
[31m-      "328",[m
[31m-      "402",[m
[31m-      "403",[m
[31m-      "406",[m
[31m-      "407"[m
[31m-    ],[m
[31m-    "2 Bdrm Club Suite" : [[m
[31m-      "105",[m
[31m-      "106B",[m
[31m-      "108",[m
[31m-      "123B",[m
[31m-      "125",[m
[31m-      "128B",[m
[31m-      "201",[m
[31m-      "207B",[m
[31m-      "208",[m
[31m-      "224",[m
[31m-      "225",[m
[31m-      "227B",[m
[31m-      "230",[m
[31m-      "306B",[m
[31m-      "308",[m
[31m-      "309",[m
[31m-      "320",[m
[31m-      "323B",[m
[31m-      "324",[m
[31m-      "326B",[m
[31m-      "327B",[m
[31m-      "328B",[m
[31m-      "330",[m
[31m-      "401",[m
[31m-      "404",[m
[31m-      "406B",[m
[31m-      "407B"[m
[31m-    ],[m
[31m-    "3 Bdrm Club Suite" : [[m
[31m-      "105B",[m
[31m-      "108B",[m
[31m-      "125B",[m
[31m-      "208B",[m
[31m-      "225B",[m
[31m-      "308B"[m
[31m-    ],[m
[31m-    "3 Bdrm Plus Den Explorer Cabin w/Hot Tub" : [[m
[31m-      "007",[m
[31m-      "010",[m
[31m-      "015"[m
[31m-    ],[m
[31m-    "3 Bdrm Townhome w/Hot Tub" : [[m
[31m-      "072",[m
[31m-      "073",[m
[31m-      "074"[m
[31m-    ],[m
[31m-    "4 Bdrm Plus Den Explorer Cabin w/Hot Tub" : [[m
[31m-      "011"[m
[31m-    ],[m
[31m-    "Studio Club Suite" : [[m
[31m-      "105A",[m
[31m-      "106A",[m
[31m-      "108A",[m
[31m-      "123A",[m
[31m-      "125A",[m
[31m-      "128A",[m
[31m-      "207A",[m
[31m-      "208A",[m
[31m-      "225A",[m
[31m-      "226A",[m
[31m-      "227A",[m
[31m-      "306A",[m
[31m-      "308A",[m
[31m-      "323A",[m
[31m-      "326A",[m
[31m-      "327A",[m
[31m-      "328A",[m
[31m-      "406A",[m
[31m-      "407A"[m
[31m-    ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "1 Bdrm Club Suite" : [[m
[32m+[m[32m//      "106",[m
[32m+[m[32m//      "121",[m
[32m+[m[32m//      "122",[m
[32m+[m[32m//      "123",[m
[32m+[m[32m//      "127",[m
[32m+[m[32m//      "128",[m
[32m+[m[32m//      "202",[m
[32m+[m[32m//      "203",[m
[32m+[m[32m//      "207",[m
[32m+[m[32m//      "220",[m
[32m+[m[32m//      "227",[m
[32m+[m[32m//      "303",[m
[32m+[m[32m//      "306",[m
[32m+[m[32m//      "323",[m
[32m+[m[32m//      "326",[m
[32m+[m[32m//      "327",[m
[32m+[m[32m//      "328",[m
[32m+[m[32m//      "402",[m
[32m+[m[32m//      "403",[m
[32m+[m[32m//      "406",[m
[32m+[m[32m//      "407"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "2 Bdrm Club Suite" : [[m
[32m+[m[32m//      "105",[m
[32m+[m[32m//      "106B",[m
[32m+[m[32m//      "108",[m
[32m+[m[32m//      "123B",[m
[32m+[m[32m//      "125",[m
[32m+[m[32m//      "128B",[m
[32m+[m[32m//      "201",[m
[32m+[m[32m//      "207B",[m
[32m+[m[32m//      "208",[m
[32m+[m[32m//      "224",[m
[32m+[m[32m//      "225",[m
[32m+[m[32m//      "227B",[m
[32m+[m[32m//      "230",[m
[32m+[m[32m//      "306B",[m
[32m+[m[32m//      "308",[m
[32m+[m[32m//      "309",[m
[32m+[m[32m//      "320",[m
[32m+[m[32m//      "323B",[m
[32m+[m[32m//      "324",[m
[32m+[m[32m//      "326B",[m
[32m+[m[32m//      "327B",[m
[32m+[m[32m//      "328B",[m
[32m+[m[32m//      "330",[m
[32m+[m[32m//      "401",[m
[32m+[m[32m//      "404",[m
[32m+[m[32m//      "406B",[m
[32m+[m[32m//      "407B"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "3 Bdrm Club Suite" : [[m
[32m+[m[32m//      "105B",[m
[32m+[m[32m//      "108B",[m
[32m+[m[32m//      "125B",[m
[32m+[m[32m//      "208B",[m
[32m+[m[32m//      "225B",[m
[32m+[m[32m//      "308B"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "3 Bdrm Plus Den Explorer Cabin w/Hot Tub" : [[m
[32m+[m[32m//      "007",[m
[32m+[m[32m//      "010",[m
[32m+[m[32m//      "015"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "3 Bdrm Townhome w/Hot Tub" : [[m
[32m+[m[32m//      "072",[m
[32m+[m[32m//      "073",[m
[32m+[m[32m//      "074"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "4 Bdrm Plus Den Explorer Cabin w/Hot Tub" : [[m
[32m+[m[32m//      "011"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "Studio Club Suite" : [[m
[32m+[m[32m//      "105A",[m
[32m+[m[32m//      "106A",[m
[32m+[m[32m//      "108A",[m
[32m+[m[32m//      "123A",[m
[32m+[m[32m//      "125A",[m
[32m+[m[32m//      "128A",[m
[32m+[m[32m//      "207A",[m
[32m+[m[32m//      "208A",[m
[32m+[m[32m//      "225A",[m
[32m+[m[32m//      "226A",[m
[32m+[m[32m//      "227A",[m
[32m+[m[32m//      "306A",[m
[32m+[m[32m//      "308A",[m
[32m+[m[32m//      "323A",[m
[32m+[m[32m//      "326A",[m
[32m+[m[32m//      "327A",[m
[32m+[m[32m//      "328A",[m
[32m+[m[32m//      "406A",[m
[32m+[m[32m//      "407A"[m
[32m+[m[32m//    ][m
[32m+[m[32m//  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "847",[m
[32m+[m[32m    "roomDescription": "4 Bdrm Plus Den Explorer Cabin w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "011" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "474",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Plus Den Explorer Cabin w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "007", "010" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4831",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Plus Den Explorer Cabin w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "014", "015" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4830",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Club Suite",[m
[32m+[m[32m    "roomNumbers" : [ "308" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4829",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Club Suite",[m
[32m+[m[32m    "roomNumbers" : [ "308B" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "328",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Club Suite",[m
[32m+[m[32m    "roomNumbers" : [ "106", "121", "122", "123", "126", "127", "128", "202", "203", "206", "207", "220", "222", "227", "303", "306", "323", "326", "327", "328", "402", "403", "406", "407" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "329",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Club Suite",[m
[32m+[m[32m    "roomNumbers" : [ "105", "106B", "108", "123B", "125" ,"126B", "128B", "201", "206B" ,"207B", "208", "224", "225", "227B", "229", "230", "306B", "308", "309", "320", "323B", "324", "326B", "327B", "328B", "330", "401", "404", "406B", "407B" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "330",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Club Suite",[m
[32m+[m[32m    "roomNumbers" : [ "105B", "108B", "125B", "208B", "225B", "229B", "308B" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "696",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Townhome w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "072", "073", "074" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "916",[m
[32m+[m[32m    "roomDescription": "Studio Club Suite",[m
[32m+[m[32m    "roomNumbers" : [ "105A", "106A", "108A", "123A", "125A", "126A", "128A", "206A", "207A", "208A", "225A", "226A", "227A", "229A", "306A", "308A", "323A", "326A", "327A", "328A", "406A", "407A" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Towering Pines.json b/resources/resortData/BigWhite/Towering Pines.json[m
[1mindex dc94993..1f700bf 100644[m
[1m--- a/resources/resortData/BigWhite/Towering Pines.json[m	
[1m+++ b/resources/resortData/BigWhite/Towering Pines.json[m	
[36m@@ -1,16 +1,30 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "TP",[m
[31m-  "rooms": {[m
[31m-    "2 Bdrm Premium w/Hot Tub" : [[m
[31m-      "03"[m
[31m-    ],[m
[31m-    "3 Bdrm Premium w/Hot Tub" : [[m
[31m-      "09",[m
[31m-      "11"[m
[31m-    ],[m
[31m-    "4 Bdrm Premium w/Hot Tub" : [[m
[31m-      "07"[m
[31m-      ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "2 Bdrm Premium w/Hot Tub" : [[m
[32m+[m[32m//      "03"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "3 Bdrm Premium w/Hot Tub" : [[m
[32m+[m[32m//      "09",[m
[32m+[m[32m//      "11"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "4 Bdrm Premium w/Hot Tub" : [[m
[32m+[m[32m//      "07"[m
[32m+[m[32m//      ][m
[32m+[m[32m//  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "919",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "03" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "378",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "09", "11" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "920",[m
[32m+[m[32m    "roomDescription": "4 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "07" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Trappers Crossing.json b/resources/resortData/BigWhite/Trappers Crossing.json[m
[1mindex 8f80f78..8ab14f6 100644[m
[1m--- a/resources/resortData/BigWhite/Trappers Crossing.json[m	
[1m+++ b/resources/resortData/BigWhite/Trappers Crossing.json[m	
[36m@@ -1,36 +1,74 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "TC",[m
[31m-  "rooms": {[m
[31m-    "1 Bdrm Plus Den Premium w/Hot Tub" : [[m
[31m-      "25"[m
[31m-    ],[m
[31m-    "1 Bdrm Premium w/Hot Tub" : [[m
[31m-      "10",[m
[31m-      "19",[m
[31m-      "21",[m
[31m-      "23",[m
[31m-      "27",[m
[31m-      "31",[m
[31m-      "33"[m
[31m-    ],[m
[31m-    "2 Bdrm Plus Loft Premium w/Hot Tub" : [[m
[31m-      "01"[m
[31m-    ],[m
[31m-    "2 Bdrm Premium w/Hot Tub" : [[m
[31m-      "02",[m
[31m-      "07",[m
[31m-      "41"[m
[31m-    ],[m
[31m-    "3 Bdrm Plus Loft Premium w/Hot Tub" : [[m
[31m-      "11",[m
[31m-      "17",[m
[31m-      "38"[m
[31m-    ],[m
[31m-    "3 Bdrm Premium w/Hot Tub" : [[m
[31m-      "22",[m
[31m-      "26",[m
[31m-      "42"[m
[31m-    ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "1 Bdrm Plus Den Premium w/Hot Tub" : [[m
[32m+[m[32m//      "25"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "1 Bdrm Premium w/Hot Tub" : [[m
[32m+[m[32m//      "10",[m
[32m+[m[32m//      "19",[m
[32m+[m[32m//      "21",[m
[32m+[m[32m//      "23",[m
[32m+[m[32m//      "27",[m
[32m+[m[32m//      "31",[m
[32m+[m[32m//      "33"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "2 Bdrm Plus Loft Premium w/Hot Tub" : [[m
[32m+[m[32m//      "01"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "2 Bdrm Premium w/Hot Tub" : [[m
[32m+[m[32m//      "02",[m
[32m+[m[32m//      "07",[m
[32m+[m[32m//      "41"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "3 Bdrm Plus Loft Premium w/Hot Tub" : [[m
[32m+[m[32m//      "11",[m
[32m+[m[32m//      "17",[m
[32m+[m[32m//      "38"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "3 Bdrm Premium w/Hot Tub" : [[m
[32m+[m[32m//      "22",[m
[32m+[m[32m//      "26",[m
[32m+[m[32m//      "42"[m
[32m+[m[32m//    ][m
[32m+[m[32m//  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "462",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Plus Loft Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "11" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "480",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "22" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4616",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "41" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "921",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Plus Den Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "25" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "649",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "10", "19", "21", "23", "27", "31", "33" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "477",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Plus Loft Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "01", "08" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "476",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "02", "07" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4617",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Plus Loft Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "17", "38" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4618",[m
[32m+[m[32m    "roomDescription": "3 Bdrm Premium w/Hot Tub",[m
[32m+[m[32m    "roomNumbers" : [ "26", "42" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/resources/resortData/BigWhite/Whitefoot Lodge.json b/resources/resortData/BigWhite/Whitefoot Lodge.json[m
[1mindex 5f38bf4..3fd5540 100644[m
[1m--- a/resources/resortData/BigWhite/Whitefoot Lodge.json[m	
[1m+++ b/resources/resortData/BigWhite/Whitefoot Lodge.json[m	
[36m@@ -1,54 +1,112 @@[m
 {[m
   "resortCode" : "01",[m
   "roomNumberCode" : "WH",[m
[31m-  "rooms": {[m
[31m-    "1 Bdrm Regular" : [[m
[31m-      "108",[m
[31m-      "208",[m
[31m-      "210",[m
[31m-      "220",[m
[31m-      "223",[m
[31m-      "227",[m
[31m-      "233",[m
[31m-      "333",[m
[31m-      "342"[m
[31m-    ],[m
[31m-    "1 Bdrm Standard" : [[m
[31m-      "107",[m
[31m-      "123"[m
[31m-    ],[m
[31m-    "2 Bdrm Regular" : [[m
[31m-      "131",[m
[31m-      "231",[m
[31m-      "334",[m
[31m-      "339",[m
[31m-      "340",[m
[31m-      "347"[m
[31m-    ],[m
[31m-    "Budget" : [[m
[31m-      "103",[m
[31m-      "113",[m
[31m-      "117",[m
[31m-      "122",[m
[31m-      "126",[m
[31m-      "129",[m
[31m-      "203",[m
[31m-      "216",[m
[31m-      "217",[m
[31m-      "315"[m
[31m-    ],[m
[31m-    "Kitchenette" : [[m
[31m-      "118",[m
[31m-      "212",[m
[31m-      "312",[m
[31m-      "316"[m
[31m-    ],[m
[31m-    "Studio" : [[m
[31m-      "105",[m
[31m-      "205",[m
[31m-      "207",[m
[31m-      "211",[m
[31m-      "306"[m
[31m-    ][m
[31m-  }[m
[32m+[m[32m//  "rooms": {[m
[32m+[m[32m//    "1 Bdrm Regular" : [[m
[32m+[m[32m//      "108",[m
[32m+[m[32m//      "208",[m
[32m+[m[32m//      "210",[m
[32m+[m[32m//      "220",[m
[32m+[m[32m//      "223",[m
[32m+[m[32m//      "227",[m
[32m+[m[32m//      "233",[m
[32m+[m[32m//      "333",[m
[32m+[m[32m//      "342"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "1 Bdrm Standard" : [[m
[32m+[m[32m//      "107",[m
[32m+[m[32m//      "123"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "2 Bdrm Regular" : [[m
[32m+[m[32m//      "131",[m
[32m+[m[32m//      "231",[m
[32m+[m[32m//      "334",[m
[32m+[m[32m//      "339",[m
[32m+[m[32m//      "340",[m
[32m+[m[32m//      "347"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "Budget" : [[m
[32m+[m[32m//      "103",[m
[32m+[m[32m//      "113",[m
[32m+[m[32m//      "117",[m
[32m+[m[32m//      "122",[m
[32m+[m[32m//      "126",[m
[32m+[m[32m//      "129",[m
[32m+[m[32m//      "203",[m
[32m+[m[32m//      "216",[m
[32m+[m[32m//      "217",[m
[32m+[m[32m//      "315"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "Kitchenette" : [[m
[32m+[m[32m//      "118",[m
[32m+[m[32m//      "212",[m
[32m+[m[32m//      "312",[m
[32m+[m[32m//      "316"[m
[32m+[m[32m//    ],[m
[32m+[m[32m//    "Studio" : [[m
[32m+[m[32m//      "105",[m
[32m+[m[32m//      "205",[m
[32m+[m[32m//      "207",[m
[32m+[m[32m//      "211",[m
[32m+[m[32m//      "306"[m
[32m+[m[32m//    ][m
[32m+[m[32m//  }[m
[32m+[m
[32m+[m[32m  "rooms": [{[m
[32m+[m[32m    "cirrusId": "924",[m
[32m+[m[32m    "roomDescription": "Studio",[m
[32m+[m[32m    "roomNumbers" : [ "207" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "923",[m
[32m+[m[32m    "roomDescription": "Kitchenette",[m
[32m+[m[32m    "roomNumbers" : [ "212" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4751",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "220" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4805",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "231" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4747",[m
[32m+[m[32m    "roomDescription": "Studio",[m
[32m+[m[32m    "roomNumbers" : [ "306" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4806",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "334" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "494",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "108", "333", "208", "233", "223" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4750",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "210", "227", "342" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "925",[m
[32m+[m[32m    "roomDescription": "1 Bdrm Standard",[m
[32m+[m[32m    "roomNumbers" : [ "107", "123" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4752",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "339", "347" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "926",[m
[32m+[m[32m    "roomDescription": "2 Bdrm Regular",[m
[32m+[m[32m    "roomNumbers" : [ "131", "340" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "922",[m
[32m+[m[32m    "roomDescription": "Budget",[m
[32m+[m[32m    "roomNumbers" : [ "103", "113", "117", "122", "126", "128", "129", "203", "216", "217", "315" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4749",[m
[32m+[m[32m    "roomDescription": "Kitchenette",[m
[32m+[m[32m    "roomNumbers" : [ "118", "312", "316" ][m
[32m+[m[32m  }, {[m
[32m+[m[32m    "cirrusId": "4748",[m
[32m+[m[32m    "roomDescription": "Studio",[m
[32m+[m[32m    "roomNumbers" : [ "105", "205", "211" ][m
[32m+[m[32m  }][m
 }[m
\ No newline at end of file[m
[1mdiff --git a/src/main/BigWhite.java b/src/main/BigWhite.java[m
[1mindex d2ed48a..b26e9dc 100644[m
[1m--- a/src/main/BigWhite.java[m
[1m+++ b/src/main/BigWhite.java[m
[36m@@ -41,9 +41,9 @@[m [mimport util.ExcelWriter;[m
 [m
 public class BigWhite {[m
 [m
[31m-	private static final boolean AGGREGATE_ROOM_TYPES = true;[m
[32m+[m	[32mprivate static final boolean AGGREGATE_ROOM_TYPES = false;[m
 	private static final String PATH_TO_HOTELS_DIRECTORY = System.getProperty("user.dir") + "/resources/resortData/BigWhite/";[m
[31m-	public static final Calendar FIRST_DATE_OF_SEASON = new GregorianCalendar(2018, 0, 8);[m
[32m+[m	[32mpublic static final Calendar FIRST_DATE_OF_SEASON = new GregorianCalendar(2018, 0, 29);[m
 	public static final Calendar FINAL_DATE_OF_SEASON = new GregorianCalendar(2018, 3, 7);[m
 [m
 	private static final String ROOM_NUMBERS_KEY = "rooms";[m
[36m@@ -56,19 +56,26 @@[m [mpublic class BigWhite {[m
 		add(HotelName.BIG_WHITE_BEARS_PAW);[m
 		add(HotelName.BIG_WHITE_BLACK_BEAR);[m
 		add(HotelName.BIG_WHITE_BULLET_CREEK);[m
[32m+[m
 		add(HotelName.BIG_WHITE_CHATEAU_RIDGE);[m
 		add(HotelName.BIG_WHITE_COPPER_KETTLE);[m
 		add(HotelName.BIG_WHITE_EAGLES);[m
 		add(HotelName.BIG_WHITE_GRIZZLY);[m
[32m+[m
 		add(HotelName.BIG_WHITE_PLAZA_RIDGE);[m
 		add(HotelName.BIG_WHITE_PTARMINGAN);[m
[32m+[m
 		add(HotelName.BIG_WHITE_SNOWY_CREEK);[m
 		add(HotelName.BIG_WHITE_STONEBRIDGE);[m
 		add(HotelName.BIG_WHITE_STONEGATE);[m
 		add(HotelName.BIG_WHITE_SUNDANCE);[m
[32m+[m
 		add(HotelName.BIG_WHITE_TOWERING_PINES);[m
 		add(HotelName.BIG_WHITE_TRAPPERS_CROSSING);[m
[32m+[m
 		add(HotelName.BIG_WHITE_WHITEFOOT);[m
[32m+[m
[32m+[m
 	}};[m
 [m
 	public static void main(String... args) throws Exception {[m
[36m@@ -226,6 +233,7 @@[m [mpublic class BigWhite {[m
 		return requestDates;[m
 	}[m
 [m
[32m+[m
 	public static Map<String, RoomAvailability> getAggregatedAvailabilitiesForRoomType(Map<String, RoomAvailability> roomAvailabilities,[m
 			Calendar startDate, Calendar endDate) {[m
 		Map<String, RoomAvailability> aggregatedRoomAvailabilities = new HashMap<String, RoomAvailability>();[m
[36m@@ -338,7 +346,8 @@[m [mpublic class BigWhite {[m
 		} else {[m
 			roomsData.put(PROPERTY_CODE_KEY, null);[m
 		}[m
[31m-		String roomNumberCode = root.get(ROOM_NUMBER_CODE_KEY).asText();[m
[32m+[m
[32m+[m[32m        String roomNumberCode = root.get(ROOM_NUMBER_CODE_KEY).asText();[m
 		String resortCode = root.get(RESORT_CODE_KEY).asText();[m
 [m
 		roomsData.put(ROOM_NUMBER_CODE_KEY, roomNumberCode);[m
[1mdiff --git a/src/main/SilverStar.java b/src/main/SilverStar.java[m
[1mindex 4551e5b..58124a1 100644[m
[1m--- a/src/main/SilverStar.java[m
[1m+++ b/src/main/SilverStar.java[m
[36m@@ -6,12 +6,7 @@[m [mimport java.io.InputStreamReader;[m
 import java.io.OutputStreamWriter;[m
 import java.net.MalformedURLException;[m
 import java.net.URL;[m
[31m-import java.util.Calendar;[m
[31m-import java.util.GregorianCalendar;[m
[31m-import java.util.HashMap;[m
[31m-import java.util.Map;[m
[31m-import java.util.Optional;[m
[31m-import java.util.Set;[m
[32m+[m[32mimport java.util.*;[m
 [m
 import javax.net.ssl.HttpsURLConnection;[m
 [m
[36m@@ -21,6 +16,7 @@[m [mimport model.ResortName;[m
 import model.RoomAvailability;[m
 import parser.SilverStarParser;[m
 import util.DateUtils;[m
[32m+[m[32mimport util.EmailAttachmentSender;[m
 import util.ExcelWriter;[m
 [m
 public class SilverStar {[m
[36m@@ -28,6 +24,14 @@[m [mpublic class SilverStar {[m
 	public static final Calendar FIRST_DATE_OF_SEASON = new GregorianCalendar(2017, 10, 23);[m
 	public static final Calendar FINAL_DATE_OF_SEASON = new GregorianCalendar(2018, 3, 8);[m
 [m
[32m+[m[32m    private static final Set<HotelName> HOTELS_TO_GET = new LinkedHashSet<HotelName>() {{[m
[32m+[m[32m        add(HotelName.SILVER_STAR_SNOWBIRD);[m
[32m+[m[32m        add(HotelName.SILVER_STAR_FIRELIGHT);[m
[32m+[m[32m        add(HotelName.SILVER_STAR_LORD_ABERDEEN);[m
[32m+[m[32m        add(HotelName.SILVER_STAR_SILVER_CREEK);[m
[32m+[m[32m        add(HotelName.SILVER_STAR_VACATION_HOMES);[m
[32m+[m[32m    }};[m
[32m+[m
 	public static void main(String[] args) throws Exception {[m
 [m
 		Calendar startDate = FIRST_DATE_OF_SEASON;[m
[36m@@ -41,11 +45,10 @@[m [mpublic class SilverStar {[m
 		roomAvailability.getAvailableDates().forEach(date -> System.out.println(DateUtils.getReadableDateString(date)));[m
 [m
 		// Write to excel file[m
[31m-		ExcelWriter.writeHotelAvailability(resortAvailability.getAvailabilityForHotel(HotelName.SILVER_STAR_SNOWBIRD));[m
[31m-		ExcelWriter.writeHotelAvailability(resortAvailability.getAvailabilityForHotel(HotelName.SILVER_STAR_FIRELIGHT));[m
[31m-		ExcelWriter.writeHotelAvailability(resortAvailability.getAvailabilityForHotel(HotelName.SILVER_STAR_LORD_ABERDEEN));[m
[31m-		ExcelWriter.writeHotelAvailability(resortAvailability.getAvailabilityForHotel(HotelName.SILVER_STAR_SILVER_CREEK));[m
[31m-		ExcelWriter.writeHotelAvailability(resortAvailability.getAvailabilityForHotel(HotelName.SILVER_STAR_VACATION_HOMES));[m
[32m+[m[32m        for (HotelName hotelName : HOTELS_TO_GET){[m
[32m+[m[32m            ExcelWriter.writeHotelAvailability(resortAvailability.getAvailabilityForHotel(hotelName));[m
[32m+[m[32m        }[m
[32m+[m[32m        EmailAttachmentSender.main(HOTELS_TO_GET);[m
 	}[m
 [m
 	public static ResortAvailability getFullAvailability(Calendar startDate, Calendar endDate) throws MalformedURLException, IOException {[m
[1mdiff --git a/src/model/HotelName.java b/src/model/HotelName.java[m
[1mindex d48d59b..966a89d 100644[m
[1m--- a/src/model/HotelName.java[m
[1m+++ b/src/model/HotelName.java[m
[36m@@ -10,7 +10,7 @@[m [mpublic enum HotelName {[m
 	BIG_WHITE_BULLET_CREEK(ResortName.BIG_WHITE, "Bullet Creek Cabins"),[m
 	BIG_WHITE_CHATEAU_RIDGE(ResortName.BIG_WHITE, "Chateau on the Ridge"),[m
 	BIG_WHITE_COPPER_KETTLE(ResortName.BIG_WHITE, "Copper Kettle Lodge"),[m
[31m-	BIG_WHITE_WHITE_CRYSTAL(ResortName.BIG_WHITE, "White Crystal Inn"),[m
[32m+[m	[32mBIG_WHITE_WHITE_CRYSTAL_INN(ResortName.BIG_WHITE, "White Crystal Inn"),[m
 	BIG_WHITE_EAGLES(ResortName.BIG_WHITE, "Eagles Resort"),[m
 	BIG_WHITE_GRIZZLY(ResortName.BIG_WHITE, "Grizzly Lodge"),[m
 	BIG_WHITE_PLAZA_RIDGE(ResortName.BIG_WHITE, "Plaza on the Ridge"),[m
[36m@@ -20,6 +20,7 @@[m [mpublic enum HotelName {[m
 	BIG_WHITE_TOWERING_PINES(ResortName.BIG_WHITE, "Towering Pines"),[m
 	BIG_WHITE_TRAPPERS_CROSSING(ResortName.BIG_WHITE, "Trappers Crossing"),[m
 	BIG_WHITE_WHITEFOOT(ResortName.BIG_WHITE, "Whitefoot Lodge"),[m
[32m+[m
 	WALNUT_BEACH_DEFAULT(ResortName.WALNUT_BEACH, "Main"),[m
 	SILVER_STAR_SNOWBIRD(ResortName.SILVER_STAR, "Snowbird Lodge"),[m
 	SILVER_STAR_FIRELIGHT(ResortName.SILVER_STAR, "Firelight Lodge"),[m
