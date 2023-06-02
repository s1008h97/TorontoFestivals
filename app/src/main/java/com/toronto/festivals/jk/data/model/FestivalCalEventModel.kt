package com.toronto.festivals.jk.data.model

import com.google.gson.annotations.SerializedName

//youngsun
//REST API를 사용해서 데이터를 받아올 데이터에 맞춰서 구현한 Model Class
//Json을 사용할 경우 @SerializedName("속성명")을 사용하는데 속성명만 데이터와 맞춰주면 변수명은 마음대로 해도 상관 없음
//나는 변수명하고 속성명 맞춰줌

/*data class FestivalCalEventModel(

    @SerializedName("calEvent")
    var calEvent : FestivalsInfoModel//calEvent라는 데이터 안에 여러가지 데이터가 있기떄문에 먼저 데이터 형태를 List로 불러와줌
)*/
data class FestivalCalEventModel(

    @SerializedName("eventName")
    var eventName: String,  //행사 이름

    @SerializedName("dates")
    var dates: List<DatesModel>, //행사 일정 가지고 오기! 하키같이 스포츠 같은 건 여러 날에 걸쳐서 진행하기 때문에 또 다른 데이터 모델을 만들어줬다.

    @SerializedName("description")
    var description : String, //shortDescription도 있는데 이거 안쓰고 그냥 첫 화면이랑 상세페이지 둘다 description으로 쓰는 것 같음

    //첫 화면에 휠체어 아이콘, 음식 아이콘, Free 아이콘에 해당하는 값들 가지고옴
    @SerializedName("accessibility")
    var accessibility : String?, // 접근성(장애), full : 가능 , 값이 없으면 불가능

    @SerializedName("freeEvent")
    var freeEvent : String, // No or Yes

    //여기에 해당하는 값은 첫화면에 보여지는 값도 있고 상세페이지에만 보이는 경우가 있음
    //💡그래서 이건 상의해봐야 할 것 같음!
    @SerializedName("features")
    var features : List<FeaturesModel>,

    @SerializedName("thumbImage")
    var thumbImage : ThumbImageModel,

    /*@SerializedName("category")
    var category : List<CategoryModel>?, // 얜 애매함, 아마 이상할 가능성 99.9%, test 해봐야함*/

    @SerializedName("locations") // 상세페이지에 where부분
    var loactions : List<LocationsModel>,

    @SerializedName("cost") // 상세페이지에 cost
    var cost : List<CostModel>,

    @SerializedName("otherCostInfo") // 정보가 있는애가 있고 없는애가 있는데 없는애들은 그냥 "" 빈 문자형태임
    var otherCostInfo : String,

    @SerializedName("reservation")
    var reservation : ReservationModel,

    @SerializedName("eventWebsite")
    var eventWebsite : String,

    )

data class DatesModel(

    @SerializedName("startDateTime")
    var startDateTimes : String, // ex. 2023-03-29T23:30:00.000Z -> 이래서 일단 데이터 String으로 받음

    @SerializedName("endDateTime")
    var endDateTime : String?, //  ?는 Nullable 의미, endDateTime이 있는게 있고 없는게 있어서

    @SerializedName("description")
    var description : String?, // 얘도 데이터가 있는 애들이 있고 없는 애들이 있음 ㅇㅇ..

)

data class FeaturesModel(

    // 여기 있는 모든 값은 true일 경우에만 존재해서 Nullable 처리
    @SerializedName("Paid Parking")
    var paidParking : Boolean?,

    @SerializedName("Public Washrooms")
    var publicWashrooms : Boolean?,

    @SerializedName("Bike Racks")
    var bikeRacks : Boolean?,

    @SerializedName("Free Parking")
    var freeParking : Boolean?,

    // 이 값만 첫 화면에서 보임, 나머지는 상세페이지에서만
    @SerializedName("Onsite Food and Beverages")
    var foodAndbeverages : Boolean?

)

data class ThumbImageModel(
    //"fileName": "market_th.png",
    //"binId": "IGHmjDovCWQNkZmhsYbMdQ",
    //"fileSize": 49022,
    //"fileType": "image/png",
    //"url": "/webapps/CC/fileAPI/edc_eventcal/market_th_IGHmjDovCWQNkZmhsYbMdQ.png"
    // 이 중에서 값을 어떤 걸 가지고 와야하는지 모르겠어서 일단 url 값만 가져옴

    @SerializedName("url")
    var url : String
)

/*data class CategoryModel(
    @SerializedName("name")
)*/

data class LocationsModel(

    @SerializedName("locationName")
    var locationName : String,

    @SerializedName("address")
    var address : String
)

data class CostModel(

    @SerializedName("from")
    var from : String,

    @SerializedName("to")
    var to : String
)

data class ReservationModel(
    @SerializedName("website")
    var website : String
)
