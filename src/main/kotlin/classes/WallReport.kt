package ru.netology.classes

import ru.netology.classes.WallService.*

class WallReport {
    private var reports = emptyArray<Report>()

    fun add (report: Report, service: WallService): Boolean {
        if (report.reason in 1..8) {
            if (service.isThereComment(report.commentId)) {
                reports += report
                return true
            } else {
                throw RuntimeException("invalid comment id (${report.commentId}) for report")
            }
        } else {
            throw RuntimeException("invalid report code")
        }
    }

    fun printAll() {
        println("List of reports:")
        for (report in reports) {
            println(report)
        }
    }
}

class Report (
    var ownerId: Long = 0,
    var commentId: Long = 0,
    var reason: Int = -1
) {
    override fun toString(): String {
        return "UserID=$ownerId, CmtID=$commentId, ReasonCode=$reason"
    }
}


