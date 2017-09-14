package com.angle.hshb.mykotlin.common

/**
 * Created by Administrator on 2017/8/24.
 */
class ForecaseResult {

    data class ForecaseResult(
            var stateCode: Int, // 0
            var data: List<Data>,
            var errorMsg: String//
    )

    data class Data(
            var contractType: Int, // 2
            var id: String, // 1dc9a400-eb67-4ef9-8479-ee2c5df5e9b5
            var contractNo: String, // 20170807009
            var houseAddress: String, // 测试楼盘111单元0101
            var beginTime: String, // 2017-08-07
            var rentMoney: String, // 55.00
            var payMode: String, // 两月付
            var pledgeMoney: String, // 55.00
            var contacts: String, // 李世豪
            var contactsTel: String, // 15558070583
            var stateKey: String, // 2
            var jiaogeState: String, // -1
            var agent: String, //
            var agentTel: String, //
            var createTime: String, // 2017-08-07
            var endTime: String, // 2018-08-07
            var contactsId: String, // 47656938-40dd-46da-b903-769ec4f25ba4
            var houseId: String, // 58878518-9d82-4ab5-88cc-6a786f2b4f4b
            var beginTimeRent: String,
            var endTimeRent: String,
            var stateKeyText: String, // 初审
            var jiaogeStateText: String, // -1
            var IdentityType: String, // 2
            var realName: String, // 思考
            var trusteeshipId: String// b40371ef-31cb-41e1-9096-9ecbffb4aa15
    )
}