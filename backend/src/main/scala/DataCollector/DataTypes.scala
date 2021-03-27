package DataCollector

import java.sql.Timestamp

case class CovidVaccination(
    cId: String,
    infected: Int,
    sick: Int,
    recovered: Int,
    dead: Int,
    sickLast7: Int,
    condition: String,
    lastUpdated: Timestamp,
    start: Timestamp,
    `cases`: Seq[Int],
    news: Seq[news],
    name: String,
    recoveriesEstimated: Boolean,
    vaccinated: Int,
    lockdownInfo: LockdownInfo
)

case class LockdownInfo(
    lockdown: String,
    details: String,
    lockdownInfoSource: String,
    lockdownStartDate: String,
    lockdownEndDate: String,
    touristEntry: String,
    touristInfoSource: String,
    touristInfo: String,
    touristBanStart: String,
    events: String,
    touristAttractions: String,
    lastUpdated: String,
    eventMoreInfo: String,
    transportMoreInfo: String,
    shopping: String,
    restaurantsAndBars: String,
    masks: Seq[String],
    quarantine: String,
    touristInfoSource2: String,
    tests: String,
    quarantineRequired: String,
    reg: String,
    regInt: Int
)

case class news(title: String, date: Timestamp, pub: String, link: String)
