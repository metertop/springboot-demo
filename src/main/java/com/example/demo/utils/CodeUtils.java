package com.example.demo.utils;

import com.google.common.collect.Maps;
import com.alibaba.fastjson.JSON;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





public class CodeUtils {

	protected CodeUtils() {
	}

	// code
	public static final String SUCCESS_CODE = "10000"; // 成功

	public static final String EXCEPTION_CODE = "11000"; // 异常

	public static final String SYSTEM_BUSY_CODE = "11011"; // 系统繁忙，接口熔断

	public static final String EMPTY_CODE = "10001"; // XXX字段数据为空

	public static final String TOO_LONG_CODE = "10002";// XXX字段太长

	public static final String API_FREQ_CODE = "10003"; // 接口调动频率超过限制

	public static final String EMPTY_LIST_CODE = "10004"; // 空白的列表

	public static final String INVALID_CODE = "10005"; // 无效的字段

	public static final String EMPTY_DAT_CODE = "10006"; // 空白的单条数据

	public static final String DATA_DUPLICATION_CODE = "10008"; // 数据重复

	/**
	 *  范围：1～totalpage
	 */
	public static final String PAGENO_INVALID_CODE = "10009"; // 当前页数值错误

	/**
	 * 数据无更新
	 */
	public static final String DATA_NO_UPDATE = "20101";
	public static final String DATA_NO_UPDATE_MSG = "data no update";

	// 范围：0～totalpage
	/**
	 * 排序格式错误 排序带逻辑正则表达式,逻辑关系可以不传默认ASC 例如：+stu_id,-valid_end,content 表示 stu_id
	 * ASC,valid_end DESC,content ASC @author tuaobin
	 **/
	public static final String SORT_FORMAT_ERROR_CODE = "20416";
	public static final String SORT_FORMAT_ERROR_MSG = "sort format error";
	/** 时间带逻辑格式错误 @author tuaobin **/
	public static final String DATE_WITH_LOGIC_FORMAT_ERROR_CODE = "20417";
	public static final String DATE_WITH_LOGIC_FORMAT_ERROR_MSG = "date format error,eg: >=YYYY-MM-DD";
	/**
	 * 排序格式错误 排序带逻辑正则表达式,逻辑关系可以不传默认ASC 例如：+stu_id,-valid_end,content 表示 stu_id
	 * ASC,valid_end DESC,content ASC @author tuaobin
	 **/
	public static final String SORT_COLUMN_ERROR_CODE = "20418";
	public static final String SORT_COLUMN_ERROR_MSG = "sort column error";
	/**
	 * 排序格式错误 排序带逻辑正则表达式,逻辑关系可以不传默认ASC 例如：+stu_id,-valid_end,content 表示 stu_id
	 * ASC,valid_end DESC,content ASC @author tuaobin
	 **/
	public static final String CONTENT_FORMAT_ERROR_CODE = "20419";
	public static final String CONTENT_FORMAT_ERROR_MSG = "content format error";
	/**
	 * 时间必须大于 2000-01-01
	 */
	public static final String DATE_TOO_EARLY_ERROR_CODE = "20420";
	public static final String DATE_TOO_EARLY_ERROR_MSG = "date must greater than 2000-01-01";
	/** 限制stu_ids 不超过100个 */
	public static final String STUIDS_COUNT_TOO_MANY_ERROR_CODE = "20421";
	public static final String STUIDS_COUNT_TOO_MANY_ERROR_MSG = "too many stu_id in stu_ids";
	/** 参数传的太少 */
	public static final String PARAMS_IS_TOO_FEW_ERROR_CODE = "20422";
	public static final String PARAMS_IS_TOO_FEW_ERROR_MSG = "params is to few,please pass more params in (stu_ids, types, content)";
	/** 排序字段必须是表中字段 */
	public static final String Sort_Filed_ERROR_CODE = "20423";
	public static final String Sort_Filed_ERROR_MSG = "sort_filed must in columns";
	/** sort is desc/DESC or asc/ASC */
	public static final String SORT_DIRECTION_ERROR_CODE = "20424";
	public static final String SORT_DIRECTION_ERROR_MSG = "sort is  desc/DESC or asc/ASC";
	public static final String POINT_TYPE_ERROR_CODE = "20425";
	public static final String POINT_TYPE_ERROR_MSG = "次卡类型有问题";

	/** 至少有一个参数 */
	public static final String PARAMS_AT_LEAST_ONE_ERROR_CODE = "20426";
	public static final String PARAMS_AT_LEAST_ONE_ERROR_MSG = "at least one param!";
	/** add_time 开始时间和结束时间至少有一个参数 */
	public static final String PARAMS_ADD_TIME_AT_LEAST_ONE_ERROR_CODE = "20427";
	public static final String PARAMS_ADD_TIME_AT_LEAST_ONE_ERROR_MSG = "add_time_start,add_time_end at least one param!";
	/** last_time 开始时间和结束时间至少有一个参数 */
	public static final String PARAMS_LAST_TIME_AT_LEAST_ONE_ERROR_CODE = "20428";
	public static final String PARAMS_LAST_TIME_AT_LEAST_ONE_ERROR_MSG = "last_time_start,last_time_end at least one param!";
	/** valid_end 开始时间和结束时间至少有一个参数 */
	public static final String PARAMS_VALID_END_AT_LEAST_ONE_ERROR_CODE = "20429";
	public static final String PARAMS_VALID_END_AT_LEAST_ONE_ERROR_MSG = "valid_end_start,valid_end_end at least one param!";

	/**排序字段格式*/
	public static final String USER_ASSETS_SORT_BY_REGEX_CODE = "20430";
	public static final String USER_ASSETS_SORT_BY_REGEX_MSG = "排序字段格式，eg：+add_time,-update_time";

	/**财富类型格式*/
	public static final String ASSETS_SKU_TYPE_REGEX_CODE = "20431";
	public static final String ASSETS_SKU_TYPE_REGEX_MSG = "财富类型格式错误";

	public static final String PAGESIZE_INVALID_CODE = "10010"; // 每页数量错误 范围
	// 0～100

	public static final String INTEGER_CODE = "10011"; // int 类型格式的字段；
	public static final String OCCUP_PEOPLE_CODE = "20215";
	public static final String OCCUP_PEOPLE_MSG = "值只能是0、1、2、3中的一个";

	public static final String INTEGER_RANGE = "10012"; // INT类型范围

	public static final String DATA_WRONGFULNESS_CODE = "10013"; // 数据不合法

	/**
	 * 数据不合法，等价于：DATA_WRONGFULNESS_CODE
	 */
	public static final String ERROR_CODE = DATA_WRONGFULNESS_CODE;

	public static final String IP_ERROR_CODE = "10014"; // ip地址格式错误

	public static final String DATETIME_ERROR_CODE = "10015"; // 日期格式错误

	public static final String LONG_RANG = "10016";

	public static final String EN_ERROR_CODE = "10017";

	public static final String ZH_ERROR_CODE = "10018";

	public static final String ID_ERROR_CODE = "10019";// id格式错误

	public static final String MIN1_TO_127_CODE = "10020";// [-1,127]

	public static final String ZERO_ONE_ERROR_CODE = "10021";

	public static final String VERSION_ERROR_CODE = "10022";

	public static final String MIN1_TO_16_CODE = "10023";

	public static final String SIBLING_ERROR_CODE = "10024";

	public static final String ZERO_TO_127_CODE = "10025";

	public static final String ZERO_TO_9999_CODE = "10026";

	public static final String DATA_NOT_EXIST_CODE = "10027";

	public static final String STATUS_ERROR_CODE = "10028";// stutus格式错误

	public static final String TYPE_ERROR_CODE = "10029";// type格式错误

	public static final String DATE_ERROR_CODE = "10030";// 时间格式错误

	public static final String TYPE_ERROR_CODE_ZERO_ONE = "10031";// 格式错误

	public static final String TYPE_ERROR_CODE_ZERO_ONE_TWO = "10032";// TYPE格式错误

	public static final String ID_MIN1_ERROR_CODE = "10033";// id格式错误,应该是[0-999..]或-1

	public static final String IDS_ERROR_CODE = "10034";// ids格式错误

	public static final String APPOINT_REPEAT_ERROR_CODE = "10035";// 重复预约

	public static final String DATE_IS_ERROR_CODE = "10036";// 日期格式错误

	public static final String DATE_ERROR_CODE_HOUR_SECOND = "10037";// 时间格式错误

	public static final String APPOINT_COST_ERROR_CODE = "10038";// 扣减点卡失败

	public static final String APPOINT_FULL_ERROR_CODE = "10039";// 课程已被预约完

	public static final String APPOINT_CANCELED_ERROR_CODE = "10040";// 课程预约已经被取消

	public static final String APPOINT_NOROOM_ERROR_CODE = "10041";// 课程预约已经被取消

	public static final String DOUBLE_RANGE = "10042";

	public static final String PROJECT_CODE_TYPE_CODE = "1043";// 项目码

	public static final String PRIMARY_KEY_DUPLICATE_ERROR_CODE = "1051";// 主键重复

	public static final String PRIMARY_KEY_DUPLICATE_ERROR_MSG = "主键id重复";

	public static final String NOT_ONE_TO_ONE_CODE = "10050";

	public static final String DUPLICATE_UNIQUE_KEY_CODE = "10051";

	public static final String DUPLICATE_UNIQUE_KEY_MSG = "数据库唯一性约束冲突";

	public static final String APPKEY_SIZE_ERROR_CODE = "10052";
	public static final String APPKEY_SIZE_ERROR_MSG = "appkey长度应在1-127之间";

	/**
	 * 操作错误（泛指）
	 */
	public static final String OPERATING_ERROR = "10080";

	/**
	 * 取值范围错误
	 */
	public static final String RANGE_ERROR = "10081";

	/** 次卡相关校验 */
	public static final String PRE_POINT = "10043";

	public static final String CURRENT_POINT = "10044";

	public static final String OPERAT_NUM = "10045";

	public static final String MIN_MAX_RANGE_CODE = "10046"; // 最小值大于最大值

	public static final String ZERO_NINETYNINE_CODE = "10047";// type范围错误

	public static final String LOW_HIGH_RANGE_CODE = "10048"; // 最小级别大于最大级别

	public static final String TAGS_IDS_ERROR_CODE = "10049";// tag_ids格式错误

	public static final String POINT_CARD_NUM_COED = "20401"; // 次卡数量不足

	public static final String MONTH_CARD_NUM_COED = "20402"; // 月卡数量不足

	public static final String GVP_CARD_NUM_COED = "20403"; // gvp卡数量不足

	public static final String CT_CARD_NUM_COED = "20404"; // ct卡数量不足

	public static final String POINT_CARD_DATE_COED = "20405"; // 次卡已经过期

	public static final String MONTH_CARD_NO_VALID_COED = "20406"; // 没有有效的月卡

	public static final String MONTH_CARD_DATE_COED = "20407"; // 当前所有月卡的剩余天数不足以用于本次约课

	public static final String GVP_CARD_DATE_COED = "20408"; // gvp已经过期

	public static final String CT_CARD_DATE_COED = "20409"; // ct已经过期

	public static final String STU_POINT_REMARK_CODE = "20410"; // 备注格式
	// "加点备注为int类型,并且长度为4";
	
	public static final String STU_POINT_REMARK_2_BIT_CODE = "20432"; // 备注格式
    // "加点备注为int类型,并且长度为4";

	public static final String STU_POINT_DATE_RANGE_CODE = "20411"; // 日期范围
	// yyyy-MM-dd_yyyy-MM-dd

	public static final String STU_POINT_DOUBLE_CODE = "20412";

	public static final String STU_POINT_HOLIDAY_DAY_NUM_CODE = "20413";

	public static final String STU_POINT_COURSE_TYPE_CODE = "20414";

	public static final String STU_POINT_TINYINT_RANGE_CODE = "20415";
	public static final String STU_POINT_HOLIDAY_IS_START_CODE = "20416";
	public static final String STU_POINT_ASSET_NOT_ENOUGH_CODE = "20417";

	/************ 课程校验相关 *********/
	public static final String DATA_JSONARRAY_ERROR_CODE = "10059";// 传入的数据不是jsonArray格式

	public static final String INTEGER_ONE_RANGE = "10061"; // 大于1的INT类型范围

	public static final String ONE_TEN_ERROR_CODE = "10062";// 1到10格式错误

	public static final String ID_ONE_ERROR_CODE = "10063";// id格式错误 大于1

	public static final String START_END_TIME_ERROR_CODE = "10064";// 课程开始时间大于结束时间

	public static final String TIME_LEN_ERROR_CODE = "10065";// 课程时长在1到999之间

	public static final String TIME_LEN_OVER_ERROR_CODE = "10066";// 课程时长大于课程开始时间和结束时间的范围

	public static final String LOST_COURSE_TIME_ERROR_CODE = "10067";// 在
	// is_circle
	// = 1
	// 的情况下，course_time_ids不能为空

	public static final String ONE_TO_FIFTY_ERROR_CODE = "10068";// 范围1 到50

	public static final String ONE_TO_NINETY_NINE_ERROR_CODE = "10069";// 范围1 //
	// 到99

	public static final String TEA_IDS_ERROR = "10070";// 传入的tea_ids有重复数据

	public static final String ONE_TWO_ERROR = "10071";// 传入的1或2
	
	public static final String CLASS_IS_DISABLEING = "10072";//班级正在禁用中

	public static final String COURSE_TIME_NOT_EXITS = "20201";

	public static final String OCCUP_CATE_NOT_EXITS = "20202";

	public static final String LOST_COURSE_TIME = "20203";

	public static final String COURSE_CATE_NOT_EXITS = "20204";

	public static final String COURSE_CAPACITY_NOT_EXITS = "20205";

	public static final String LEVEL_CATE_NOT_EXITS = "20206";

	public static final String COURSE_TIME_ID_NOT_EXITS = "20207";

	public static final String COURSE_TIME_EXIT_FORMAT_ERROR = "20208";

	public static final String COURSE_TIME_FORMAT_ERROR = "20209";

	public static final String APPOINT_COURSE_ERROR = "20210";

	public static final String TEXTBOOK_DATE_RMPTY_ERROR = "20211";

	public static final String TEXTBOOK_EXECPTION_ERROR = "20212";

	public static final String COURSE_ALREADY_APPOINT_ERROR = "20213";

	public static final String COURSE_TYPE_ERROR = "20214"; // course_type

	// 范围1 到999

	public static final String COURSE_CLASS_HASBIND_GOODS = "20215";// 班级已经绑定商品

	public static final String CLASS_HAS_POINT_STUDENTS = "20216";// 班级已经有学生报名

	/*************** 商品相关 *************************/
	public static final String GOOD_REFUND_MULTI_CODE = "20501";// 商品退费操作过于频繁

	public static final String GOOD_STOCKUM_CODE = "20502";// 商品库存不足

	public static final String GOOD_CLASS_CODE = "20503";// 商品班课不存在

	public static final String GOOD_DEDUCT_STOCKUM_CODE = "20504";// 商品扣除库存失败

	public static final String GOOD_EXCHANGE_CODE = "20505";// 商品更换

	public static final String GOOD_STOCKUM_STATUS_CODE = "20506";// 商品库存不足和状态不对

	public static final String GOOD_NON_EXISTENT_CODE = "20507";// 商品库存不足和状态不对

	public static final String CLASS_STOCKUM_CODE = "20508";// 商品库存不足和状态不对

	public static final String REPEAT_BUY_CODE = "20509";// 重复购买

	public static final String REPEAT_EXCHANGE_CODE = "20510";// 重复购买

	public static final String CLASS_DEDUCT_STOCKUM_CODE = "20511";// 班级扣除库存失败

	public static final String UPDATE_STOCKUM_CODE = "20512";// 修改容量失败

	public static final String GOOD_STATUS_CODE = "20513";// 商品状态
	
	public static final String SUBSCRIBE_CLASS_CODE = "20514";// 商品调用约课，约课服务

	public static final String CLASS_STATUS_CODE = "20515";// 班级状态

	// 修改class状态为禁用失败，class 已经有人报名了
	public static final String UPDATE_CLASS_STATUS_FOR_DISABLE_CODE = "20516";
	/**
	 * 每页数量范围错误码 1-200
	 */
	public static final String PAGEZISE_RANGE_ERROR_CODE = "20517";
	/**
	 * 多个ID错误
	 */
	public static final String MULTI_ID_ERROR_CODE = "20518";
	/**
	 * 商品BU可选为all,{seller_id}
	 */
	public static final String GOODS_SELLER_ID_ERROR_CODE = "20519";
	/**
	 * 调用课程失败
	 */
	public static final String GOODS_INVOKE_COURSE_EROOR_CODE = "20520";
	/**
	 * 调用课程获取class bu失败
	 */
	public static final String CLASS_BU_INVOKE_COURSE_EROOR_CODE = "20521";
	/**
	 * 调商品下班级是空
	 */
	public static final String GOODS_CLASS_EMPTY_CODE = "20522";
	/**
	 * 调用约课换商品失败
	 */
	public static final String APPOINT_EXCHANGE_STUDENT_EROOR_CODE = "20523";
	
	/**
	 * 商品ENTITY不存在
	 */
	public static final String GOODS_ENTITY_NOT_EXIST_EROOR_CODE = "20524";
	
	/**
	 * 找不到选班记录
	 */
	public static final String STU_SELECT_CLASS_NOT_EXIST_EROOR_CODE = "20525";
	
	/**
	 * 调用订单失败
	 */
	public static final String GOODS_INVOKE_ORDER_EROOR_CODE = "20526";

	/**
	 * 找不到学生选班记录
	 */
	public static final String STU_SELECT_CLASS_ORDER_ID_EROOR_CODE = "20527";

	/**
	 * 商品必须候选班商品
	 */
	public static final String GOODS_APOLLO_CLASS_AFTER_SELECT_ERROR_CODE = "20528";

	/*************** 订单相关 *************************/
	public static final String ORDER_ORDER_NOT_EXIST_CODE = "20701";

	public static final String ORDER_REFUND_ORDER_NOT_EXIST_CODE = "20702";

	public static final String ORDER_ORDER_ID_STU_ID_NO_EQULS_CODE = "20703";

	public static final String ORDER_ORDER_DEPOSIT_NOT_EXIST_CODE = "20704";

	public static final String ORDER_REFUND_ORDER_EXIST_CODE = "20705";

	public static final String USER_ORDER_GOODS_NOT_EXIST_CODE = "20706";

	public static final String USER_ORDER_SPU_NOT_EXIST_CODE = "20707";
	
	public static final String APPOINT_EROOR_CODE = "20708";
	
	public static final String GOODS_EROOR_CODE = "20709";
	
	
	public static final String ORDER_GOODS_EROOR_CODE = "20710";
	
	public static final String ORDER_ORDER_FROM_TYPE_EROOR_CODE = "20711";
	
	
	public static final String ORDER_ORDER_STATUS_EROOR_CODE = "20712";
	
	
	public static final String ORDER_ORDER_RENEWAL_NOT_EXIST_CODE = "20713";

	public static final String SORTBY_COLUMN_ERROR_CODE = "20714";//排序不正确
	
	
	public static final String CLASS_NOT_EXIST_ERROR_CODE = "20715";//调用RPC班级不存在


	/*************** 教材相关 *************************/
	public static final String TEXTBOOK_NONSERIESTEXTBOOK_USED_COURSE = "20801";

	// message
	public static final String SUCCESS_MSG = "success"; // 成功

	public static final String EXCEPTION_MSG = "system exception"; // 异常

	public static final String EMPTY_MSG = "empty option "; // XXX字段数据为空

	public static final String TOO_LONG_MSG = "too long ";// XXX字段太长

	public static final String API_FREQ_MSG = "api freq out of limit"; // 接口调动频率超过限制

	public static final String EMPTY_LIST_MSG = "empty list size"; // 空白的列表

	public static final String INVALID_MSG = "invalid "; // 无效的字段

	public static final String EMPTY_DAT_MSG = "empty data"; // 空白的单条数据

	public static final String DATA_DUPLICATION_MSG = "data duplication"; // 数据重复

	public static final String PAGENO_INVALID_MSG = " range 1~totalpage";

	public static final String PAGESIZE_INVALID_MSG = " range 1~999";

	public static final String INTEGER_MSG = " is int";

	public static final String INTEGER_RANGE_MSG = "  int rang is 0~2147483647";

	public static final String LONG_RANG_MSG = "  long rang is 0~9223372036854775807";

	public static final String DATA_WRONGFULNESS_MSG = "data wrongfulness"; // 数据不合法

	public static final String IP_ERROR_MSG = " format error"; // ip地址格式错误

	public static final String DATETIME_ERROR_MSG = " format error"; // 日期格式错误

	public static final String EN_ERROR_MSG = "must enter English";

	public static final String ZH_ERROR_MSG = "must enter Chinese";

	public static final String ID_ERROR_MSG = "should range 0~999999999999999999";

	public static final String MIN1_TO_127_MSG = "should range -1~127";

	public static final String ZERO_ONE_ERROR_MSG = "should be 0 or 1";

	public static final String VERSION_ERROR_MSG = "should be -1 or range 0~999999999";

	public static final String MIN1_TO_16_MSG = "should range -1~16";

	public static final String SIBLING_ERROR_MSG = "should be -1 or range 0~999999999";

	public static final String ZERO_TO_127_MSG = "should range 0~127";

	public static final String POSITIVE_INTEGER_RANGE_MSG_ = "  int rang is 1~2147483647";

	public static final String ZERO_TO_9999_MSG = "should range 0~9999";

	public static final String DATA_NOT_EXIST_MSG = "查询的数据不存在";

	public static final String DATA_STATUS_ERROR_MSG = " range is 0~10";

	public static final String DATA_TYPE_ERROR_MSG = " range is 1~999999999";

	public static final String DATE_TYPE_ERROR_MSG = " type is yyyy-MM-dd HH:mm:ss";

	public static final String DATE_TYPE_ERROR_ONE_ZERO_MSG = "  is 0 or 1";

	public static final String DATE_TYPE_ERROR_ONE_ZERO_TWO_MSG = "  is 0 or 1 or 2";

	public static final String IDS_ERROR__MSG = "  应该以逗号分割，data should range 0~999999999999999999";

	public static final String ID_MIN1_ERROR_MSG = "should range -1~999999999999999999";

	public static final String DATE_IS_ERROR_MSG = "type is yyyy-MM-dd";

	public static final String DATE_HOUR_SECOND_ERROR_MSG = "should HH:mm";

	public static final String APPOINT_REPEAT_ERROR_MSG = "appoint repeat";

	public static final String APPOINT_COST_ERROR_MSG = "cost point failure";

	public static final String APPOINT_FULL_ERROR_MSG = "course is full";

	public static final String APPOINT_CANCELED_ERROR_MSG = "course was cancened";

	public static final String APPOINT_NOROOM_ERROR_MSG = "room not exist";

	public static final String DOUBLE_RANGE_ERROR_MSG = "should range is double example:1.0";

	public static final String MIN_MAX_RANGE_ERROR_MSG = "min 应该小于 max";

	public static final String ZERO_NINETYNINE_ERROR_MSG = "should range 0~99";

	public static final String LOW_HIGH_RANGE_ERROR_MSG = "low 应该小于 high";

	public static final String TAGS_IDS_ERROR_MSG = "应该以逗号分隔，范围0到99";

	public static final String INTEGER_ONE_MSG = "  int rang is 1~2147483647";

	public static final String DOUBLE_RANGE_MSG = "  不能大于99.9";

	public static final String ONE_TEN_REEOR_MSG = " 只能为1~10";

	public static final String ONE_NINETYNINE_ERROR_MSG = "should range 1~99";

	public static final String ID_ONE_REEOR_MSG = " should range 1~999999999999999999";

	public static final String START_END_TIME_REEOR_MSG = " start_time 应该小于 end_time";

	public static final String TIME_LEN_REEOR_MSG = " should range 1~999";

	public static final String TIME_LEN_OVER_REEOR_MSG = " time_len大小应该小于 time_start和time_end的范围";

	public static final String LOST_COURSE_TIME_ERROR_MSG = "在 is_circle = 1 的情况下，course_time_ids不能为空";//

	public static final String ONE_TO_FIFTY_ERROR_MSG = "范围是1到50之间";//

	public static final String NOT_ONE_TO_ONE_MSG = "一对一关系";//

	public static final String RANGE_ERROR_MSG = "取值范围错误";

	/** 次卡相关校验 */

	public static final String PRE_POINT_ERROR_MSG = "type is int and max length 10";

	public static final String CURRENT_POINT_ERROR_MSG = "type is int and max length 10";

	public static final String OPERAT_NUM_ERROR_MSG = "type is int and max length 11";

	public static final String POINT_CARD_NUM_MSG = "次卡余量不足"; // 次卡数量不足

	public static final String MONTH_CARD_NUM_MSG = "月卡数量不足"; // 月卡数量不足

	public static final String GVP_CARD_NUM_MSG = "GVP课时数量不足"; // GVP课时数量不足

	public static final String CT_CARD_NUM_MSG = "ct卡数量不足"; // ct卡数量不足

	public static final String STU_POINT_HOLIDAY_DAY_NUM_MSG = "请假天数范围1~99";

	public static final String STU_POINT_COURSE_TYPE_MSG = "data range is   1~100";

	public static final String POINT_CARD_DATE_MSG = "次卡已经过期"; // 次卡已经过期

	public static final String MONTH_CARD_NO_VALID_MSG = "没有有效的月卡"; // 没有有效的月卡

	public static final String MONTH_CARD_DATE_MSG = "当前所有月卡的剩余天数不足以用于本次约课"; // 当前所有月卡的剩余天数不足以用于本次约课

	public static final String GVP_CARD_DATE_MSG = "gvp已经过期"; // gvp已经过期

	public static final String CT_CARD_DATE_MSG = "ct已经过期"; // ct已经过期

	public static final String STU_POINT_REMARK_MSG = "tinyint类型,并且长度为4";
	
	public static final String STU_POINT_REMARK_2_BIT_MSG = "只能1-99";

	public static final String STU_POINT_DATE_RANGE_MSG = "date range is yyyy-MM-dd_yyyy-MM-dd"; // 日期范围
	// yyyy-MM-dd_yyyy-MM-dd

	public static final String STU_POINT_DOUBLE_MSG = "should range is double example:1.0";

	public static final String STU_POINT_TINYINT_RANGE_MSG = " range is  0~255";
	public static final String STU_POINT_HOLIDAY_IS_START_MSG = "请假已经开始,不能取消";
	public static final String STU_POINT_ASSET_NOT_ENOUGH_MSG = "当前财富不够";

	/************* 课程相关校验 **************/
	public static final String COURSE_COST_LOST_COST_TYPE_MSG = "c_course_costs参数中cost_type字段不能为空";

	public static final String COURSE_COST_LOST_CODE_NUM = "c_course_costs参数中code_num字段不能为空";

	public static final String COURSE_COST_LOST_ITEM_ID = "c_course_costs参数中code_item_id字段不能为空";

	public static final String COURSE_COST_LOST_PRIORITY = "c_course_costs参数中priority字段不能为空";

	public static final String COURSE_TIME_LOST_ID = "course_times参数中id字段不能为空";

	public static final String COURSE_TIME_LOST_TYPE = "course_times参数中time_type字段不能为空";

	public static final String COURSE_TIME_LOST_TAG = "course_times参数中time_tag字段不能为空";

	public static final String COURSE_TIME_LOST_START = "course_times参数中time_start字段不能为空";

	public static final String COURSE_TIME_LOST_END = "course_times参数中time_end字段不能为空";

	public static final String COURSE_TIME_LOST_LEN = "course_times参数中time_len字段不能为空";

	public static final String COURSE_TIME_LOST_STATUS = "course_times参数中id不为空的情况下status字段不能为空";

	public static final String COURSE_DETAIL_LOST_BOOK_ID = "course_detail参数中book_id不能为空";

	public static final String COURSE_DETAIL_LOST_START_TIME = "course_detail参数中start_time不能为空";

	public static final String COURSE_DETAIL_LOST_END_TIME = "course_detail参数中end_time不能为空";

	public static final String TEA_IDS_ERROR_MSG = "传入的tea_ids有重复数据";// 传入的tea_ids有重复数据

	public static final String LESSONS_LOST_BOOK_ID = "lessons参数中book_id不能为空";

	public static final String LESSONS_LOST_START_TIME = "lessons参数中start_time不能为空";

	public static final String LESSONS_LOST_END_TIME = "lessons参数中end_time不能为空";

	public static final String COURSE_TERMINALS_LOST_PARENT_TERMINAL_MSG = "terminals参数中parent_terminal字段不能为空";

	public static final String COURSE_TERMINALS_LOST_TERMINAL_MSG = "terminals参数中terminal字段不能为空";

	/************* 新版课程课程相关校验 **************/
	public static final String COURSE_PROPERTYS_LOST_PROPERTY_ID_MSG = "course_propertys参数中property_id字段不能为空";

	public static final String COURSE_PROPERTYS_LOST_PROPERTY_VAL_ID_MSG = "course_propertys参数中property_val_id字段不能为空";

	public static final String COURSE_TYPE_ERROR_MSG = " range is 1~999";

	/**************** 商品 **********************************/
	public static final String GOOD_REFUND_MULTI_MSG = "goods frequent operation";

	public static final String GOOD_STOCKUM_MSG = "商品库存不足";

	public static final String GOOD_CLASS_MSG = "goods class non-existent";

	public static final String GOOD_DEDUCT_STOCKUM_MSG = "修改商品库存失败";

	public static final String GOOD_EXCHANGE_MSG = "goods exchange   失败";

	public static final String GOOD_STOCKUM_STATUS_MSG = "goods stockum insufficient and status wrong";

	public static final String GOOD_NON_EXISTENT_MSG = "goods  non-existent";

	public static final String CLASS_STOCKUM_MSG = "班级库存不足";

	public static final String REPEAT_BUY_MSG = "repeat_buy";

	public static final String REPEAT_EXCHANGE_MSG = "repeat_exchange";

	public static final String CLASS_DEDUCT_STOCKUM_MSG = "修改班级库存失败";

	public static final String UPDATE_STOCKUM_MSG = "update stockum  失败";

	public static final String GOOD_STATUS_MSG = "goods status wrong";

	public static final String SUBSCRIBE_CLASS_MSG = "约课生成课表失败";

	public static final String UPDATE_CLASS_STATUS_FOR_DISABLE_MSG = "修改class为禁用状态失败，class已经有人报名";

	public static final String CLASS_STATUS_MSG = "class_status_wrong";
	
	/**
	 * 每页数量范围错误提示
	 */
	public static final String PAGEZISE_RANGE_ERROR_MSG = "page_size int range is 1-200";

	/**
	 * 多个ID错误提示（必须是数字并且使用逗号分隔）
	 */
	public static final String MULTI_ID_ERROR_MSG = " multi id must integer and separate by comma and max length is 10";
	public static final String GOODS_SELLER_ID_ERROR_MSG = "seller_id must in 'all' or goods_seller.seller_id ";
	/**
	 * 调用约课换商品失败
	 */
	public static final String APPOINT_EXCHANGE_STUDENT_EROOR_MSG = " invoke appoint mudule occur exception";// 班级状态
	/**
	 * 调用课程失败
	 */
	public static final String GOODS_INVOKE_COURSE_EROOR_MSG = "goods invoke course mudule occur exception";// 获取bu
	/**
	 * 调用课程获取class bu失败
	 */
	public static final String CLASS_BU_INVOKE_COURSE_EROOR_MSG = "goods invoke course mudule get class bu exception";// 获取bu
	/**
	 * 调商品下班级是空
	 */
	public static final String GOODS_CLASS_EMPTY_MSG = "goods class empty";//商品下班级是空
	
	/**
	 * 调用课程获取class bu失败
	 *
	public static final String CLASS_BU_INVOKE_COURSE_EROOR_MSG = "goods invoke course mudule get class bu exception";// 获取bu
	/**
	 * 商品ENTITY不存在
	 */
	public static final String GOODS_ENTITY_NOT_EXIST_EROOR_MSG = "goods entity not exist";// 获取bu
	/**
	 * 找不到选班记录
	 */
	public static final String STU_SELECT_CLASS_NOT_EXIST_EROOR_MSG = "can not find select class log";
	
	/**
	 * 调用订单失败
	 */
	public static final String GOODS_INVOKE_ORDER_EROOR_MSG = "goods invoke order mudule occur exception";
	/**
	 * 找不到学生选班记录
	 */
	public static final String STU_SELECT_CLASS_ORDER_ID_EROOR_MSG = "student select class log order id error";
	/**
	 * 商品必须候选班商品
	 */
	public static final String GOODS_APOLLO_CLASS_AFTER_SELECT_ERROR_MSG = "goods must apollo class and after select ";
	

	/********************** 老师相关的校验 ****************/
	public static final String TINY_INT_CODE = "10500";

	public static final String TINY_INT_MSG = "有符号的tiny int 的取值范围是0到127";

	public static final String ZERO_OR_ONE_CODE = "10501";

	public static final String ZERO_OR_ONE_MSG = "值只能是0或者1";

	public static final String SEX_CODE = "10502";

	public static final String SEX_MSG = "取值只能是men或者women";

	public static final String COMMA_JOINED_TEACHER_IDS_CODE = "10517";

	public static final String COMMA_JOINED_TEACHER_IDS_MSG = "只能是逗号分隔的老师id";

	public static final String DATE_CODE = "10503";

	public static final String DATE_MSG = "日期格式只能是yyyy-MM-dd";

	public static final String YES_OR_NO_CODE = "10504";

	public static final String YES_OR_NO_MSG = "取值只能是y或者n";

	public static final String TEACH_STATTION_CODE = "10505";

	public static final String TEACH_STATTION_MSG = "取值只能是home或者office";

	public static final String ON_OR_OFF_CODE = "10506";

	public static final String ON_OR_OFF_MSG = "取值只能是on或者off";

	public static final String COURSE_CODE = "10507";

	public static final String COURSE_MSG = "取值只能是obt、hbt、cejunior、nce、ce、daily、be、iet、kid、inter、tr、cu、new、ca、idx、so、ft中的一个";

	public static final String TEACHER_STATUS_CODE = "10508";

	public static final String TEACHER_STATUS_MSG = "取值只能是on、off、hei、pending中的一个";

	public static final String TEACH_TYPE_CODE = "10509";

	public static final String TEACH_TYPE_MSG = "取值只能是1或者2";

	public static final String MANDARIN_SPEAKER_CODE = "10510";

	public static final String MANDARIN_SPEAKER_MSG = "取值范围是0、1、2";

	public static final String TEACHER_INFO_OPERATOR_CODE = "10511";

	public static final String TEACHER_INFO_OPERATOR_MSG = "此类型是bignit 20位";

	public static final String DAY_OF_WEEK_CODE = "10512";

	public static final String DAY_OF_WEEK_MSG = "一周的某一天只能是1到7中的一个";

	public static final String ONE_OR_TWO_CODE = "10513";

	public static final String ONE_OR_TWO_MSG = "取值只能是1或者2";

	public static final String WORKFORCE_SCHDULE_DERIVED_FROM_CODE = "10514";

	public static final String WORKFORCE_SCHDULE_DERIVED_FROM_MSG = "人力资源计划的来源表只能是hbtAutoLesson、nonfilFeelLesson、enaAppTime中的一个";

	public static final String PROJECT_RESOURCE_POOL_DERIVED_FROM_CODE = "10515";

	public static final String PROJECT_RESOURCE_POOL_DERIVED_FROM_MSG = "教学项目资源的来源表只能是gvpTeacher、teaUsable、hbtTeaNew、nonfilTeacher中的一个";

	public static final String SCHEDULE_PATTERN_DERIVED_FROM_CODE = "10516";

	public static final String SCHEDULE_PATTERN_DERIVED_FROM_MSG = "资源计划模式的来源表只能是gvpTeacherTime、teaUsableTime中的一个";

	public static final String TRUE_OR_FALSE_CODE = "10518";

	public static final String TRUE_OR_FALSE_MSG = "取值只能是true或者false";

	public static final String COMMA_JOINED_NUMBER_CODE = "10519";

	public static final String COMMA_JOINED_NUMBER_MSG = "取值为逗号分隔的数字";

	public static final String MOBILE_CODE = "10520";

	public static final String MOBILE_MSG = "手机号格式有误";

	public static final String YEAR_MONTH_CODE = "10521";

	public static final String YEAR_MONTH_MSG = "年月输入格式有误，格式为1999-01";

	public static final String TIMESTAMP_ERROR_CODE = "10522";

	public static final String TIMESTAMP_ERROR_MSG = "10522";

	public static final String FLOAT_CODE = "10523";

	public static final String FLOAT_MSG = "浮点数格式不正确";

	public static final String TIME_CODE = "10524";

	public static final String TIME_MSG = "time 格式 为  20160809_30";

	public static final String PROJECT_CODE_OF_MUTI_CODE = "10525";

	public static final String PROJECT_CODE_OF_MUTI_MSG = "project_code的值只能为gvp|ce|ac_gc";

	public static final String HAS_CANCEL_CODE = "10526";

	public static final String HAS_CANCEL_MSG = "没有发现取消收藏的老师";

	public static final String OPEN_STATUS_CODE = "10527";

	public static final String OPEN_STATUS_MSG = "取值只能为on|off|t_absent|t_exchange";

	public static final String APPOINT_STATUS_CODE = "10528";

	public static final String APPOINT_STATUS_MSG = "约课状态取值范围：1、2、3";

	public static final String SCORE_TYPE_CODE = "10529";

	public static final String SCORE_TYPE_MSG = "评分类别只能是adult|kids";

	public static final String TEACHER_IDS_LIMIT_MSG = "老师id最大100个";

	public static final String TEACHER_IDS_LIMIT_CODE = "10530";

	public static final String CLASS_TIME_LIMIT_MSG = "查询时间跨度太大";

	public static final String CLASS_TIME_LIMIT_CODE = "10531";

	/*************** 订单相关 *************************/
	public static final String ORDER_ORDER_NOT_EXIST_MSG = "order_not_exist";

	public static final String ORDER_REFUND_ORDER_NOT_EXIST_MSG = "refund_order_not_exist";

	public static final String ORDER_ORDER_ID_STU_ID_NO_EQULS_MSG = "order_id 或 stu_id 不对应 ";

	public static final String ORDER_ORDER_DEPOSIT_NOT_EXIST_MSG = "refund_deposit_not_exist";

	public static final String ORDER_REFUND_ORDER_EXIST_MSG = "退款的order_id已存在";

	public static final String USER_ORDER_GOODS_NOT_EXIST_MSG = "商品和套餐,拆分记录不存在";

	public static final String APPOINT_EROOR_MSG = "调用约课服务失败";
	
	public static final String GOODS_EROOR_MSG = "调用商品服务失败";
	
	
	public static final String ORDER_GOODS_EROOR_MSG = "goods_id_not_exist";
	
	public static final String ORDER_ORDER_FROM_TYPE_EROOR_MSG = "from_type 不正确";
	
	public static final String ORDER_ORDER_STATUS_EROOR_MSG = "订单状态正确";
	
	
	public static final String ORDER_ORDER_RENEWAL_NOT_EXIST_MSG = "符合条件的原班续原班订单不存在";
	
	
	public static final String SORTBY_COLUMN_ERROR_MSG = "sortby column error";
	
	
	public static final String CLASS_NOT_EXIST_ERROR_MSG = "班级ID不存在";//调用RPC班级不存在

	/*************** 教材相关 *************************/
	public static final String TEXTBOOK_NONSERIESTEXTBOOK_USED_COURSE_MSG = "此教材被课程使用中";

	public static final String APPOINT_TYPE_ERROR_CODE = "10730";

	public static final String APPOINT_TYPE_ERROR_MSG = "次卡类型有问题";

	public static final String APPOINT_STATUS_MUTY_ERROR_CODE = "10731";

	public static final String APPOINT_STATUS_MUTY_ERROR_MSG = "约课状态请选择on|end|cancel|s_absent|t_absent中的一个或多个(多个以逗号分隔)";

	/**
	 * 校验ip是否合法
	 * 
	 * @param ipAddress
	 * @return
	 */
	public static boolean isIpv4(String ipAddress) {

		String ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
				+ "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+ "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+ "(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

		Pattern pattern = Pattern.compile(ip);
		Matcher matcher = pattern.matcher(ipAddress);
		return matcher.matches();

	}

	public static void main(String[] args) {
		System.out.println(isIpv4("1.1.1.101"));
		System.out.println(toErrorMessage("10001", "userName"));
	}


	public static String toErrorMessage(String errorCode, String field) {
		Map<String, String> map = Maps.newConcurrentMap();
		// 将所有非蛇形的属性名称转换为蛇形的形式返回
		field = StringUtils.toUnderScoreCase(field);
		switch (errorCode) {
			case CodeUtils.EXCEPTION_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.EXCEPTION_MSG);
//				return JSON.toJSONString(map);

				return JSON.toJSONString(map);
			case CodeUtils.EMPTY_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.EMPTY_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TOO_LONG_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TOO_LONG_MSG);
				return JSON.toJSONString(map);

			case CodeUtils.API_FREQ_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.API_FREQ_MSG);
				return JSON.toJSONString(map);

			case CodeUtils.EMPTY_LIST_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.EMPTY_LIST_MSG);
				return JSON.toJSONString(map);

			case CodeUtils.INVALID_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.INVALID_MSG);
				return JSON.toJSONString(map);

			case CodeUtils.EMPTY_DAT_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.EMPTY_DAT_MSG);
				return JSON.toJSONString(map);

			case CodeUtils.DATA_DUPLICATION_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATA_DUPLICATION_MSG);
				return JSON.toJSONString(map);

			case CodeUtils.PAGENO_INVALID_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.PAGENO_INVALID_MSG);
				return JSON.toJSONString(map);

			case CodeUtils.PAGESIZE_INVALID_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.PAGESIZE_INVALID_MSG);
				return JSON.toJSONString(map);

			case CodeUtils.INTEGER_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.INTEGER_MSG);
				return JSON.toJSONString(map);

			case CodeUtils.INTEGER_RANGE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.INTEGER_RANGE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.DATA_WRONGFULNESS_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATA_WRONGFULNESS_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.IP_ERROR_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.IP_ERROR_MSG);
				return JSON.toJSONString(map);

			case CodeUtils.DATETIME_ERROR_CODE:

				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATETIME_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.LONG_RANG:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.LONG_RANG_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.EN_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.EN_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ZH_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ZH_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ID_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ID_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.MIN1_TO_127_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.MIN1_TO_127_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ZERO_ONE_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ZERO_ONE_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.VERSION_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.VERSION_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.MIN1_TO_16_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.MIN1_TO_16_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.SIBLING_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.SIBLING_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ZERO_TO_127_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ZERO_TO_127_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ZERO_TO_9999_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ZERO_TO_9999_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.DATA_NOT_EXIST_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATA_NOT_EXIST_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.STATUS_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATA_STATUS_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TYPE_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATA_TYPE_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.DATE_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATE_TYPE_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TYPE_ERROR_CODE_ZERO_ONE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATE_TYPE_ERROR_ONE_ZERO_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TYPE_ERROR_CODE_ZERO_ONE_TWO:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATE_TYPE_ERROR_ONE_ZERO_TWO_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.IDS_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.IDS_ERROR__MSG);
				return JSON.toJSONString(map);
			case CodeUtils.DATE_ERROR_CODE_HOUR_SECOND:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATE_HOUR_SECOND_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ID_MIN1_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ID_MIN1_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.APPOINT_REPEAT_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.APPOINT_REPEAT_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.APPOINT_COST_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.APPOINT_COST_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.APPOINT_FULL_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.APPOINT_FULL_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.APPOINT_CANCELED_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.APPOINT_CANCELED_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.APPOINT_NOROOM_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.APPOINT_NOROOM_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.DATE_IS_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATE_IS_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.DOUBLE_RANGE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DOUBLE_RANGE_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.PRE_POINT:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.PRE_POINT_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.CURRENT_POINT:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.CURRENT_POINT_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.OPERAT_NUM:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.OPERAT_NUM_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.MIN_MAX_RANGE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.MIN_MAX_RANGE_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ZERO_NINETYNINE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ZERO_NINETYNINE_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.LOW_HIGH_RANGE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.LOW_HIGH_RANGE_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TAGS_IDS_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TAGS_IDS_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.STU_POINT_REMARK_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.STU_POINT_REMARK_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.STU_POINT_REMARK_2_BIT_CODE:
                map.put("code", errorCode);
                map.put("message", field + " " + CodeUtils.STU_POINT_REMARK_2_BIT_MSG);
                return JSON.toJSONString(map);
			case CodeUtils.INTEGER_ONE_RANGE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.INTEGER_ONE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ONE_TEN_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ONE_TEN_REEOR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ID_ONE_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ID_ONE_REEOR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.START_END_TIME_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.START_END_TIME_REEOR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TIME_LEN_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TIME_LEN_REEOR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TIME_LEN_OVER_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TIME_LEN_OVER_REEOR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ONE_TO_FIFTY_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ONE_TO_FIFTY_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.STU_POINT_DATE_RANGE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.STU_POINT_DATE_RANGE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ONE_TO_NINETY_NINE_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ONE_NINETYNINE_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.STU_POINT_DOUBLE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.STU_POINT_DOUBLE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.STU_POINT_HOLIDAY_DAY_NUM_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.STU_POINT_HOLIDAY_DAY_NUM_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.STU_POINT_TINYINT_RANGE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.STU_POINT_TINYINT_RANGE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.NOT_ONE_TO_ONE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.NOT_ONE_TO_ONE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.GOOD_REFUND_MULTI_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.GOOD_REFUND_MULTI_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TINY_INT_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TINY_INT_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ZERO_OR_ONE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ZERO_OR_ONE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.SEX_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.SEX_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.DATE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DATE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.YES_OR_NO_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.YES_OR_NO_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TEACH_STATTION_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TEACH_STATTION_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ON_OR_OFF_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ON_OR_OFF_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.COURSE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.COURSE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TEACHER_STATUS_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TEACHER_STATUS_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TEACH_TYPE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TEACH_TYPE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.MANDARIN_SPEAKER_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.MANDARIN_SPEAKER_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TEACHER_INFO_OPERATOR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TEACHER_INFO_OPERATOR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.DAY_OF_WEEK_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DAY_OF_WEEK_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ONE_OR_TWO_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ONE_OR_TWO_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.WORKFORCE_SCHDULE_DERIVED_FROM_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.WORKFORCE_SCHDULE_DERIVED_FROM_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.PROJECT_RESOURCE_POOL_DERIVED_FROM_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.PROJECT_RESOURCE_POOL_DERIVED_FROM_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.SCHEDULE_PATTERN_DERIVED_FROM_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.SCHEDULE_PATTERN_DERIVED_FROM_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.COMMA_JOINED_TEACHER_IDS_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.COMMA_JOINED_TEACHER_IDS_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TRUE_OR_FALSE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TRUE_OR_FALSE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.COMMA_JOINED_NUMBER_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.COMMA_JOINED_NUMBER_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.MOBILE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.MOBILE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.YEAR_MONTH_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.YEAR_MONTH_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TIMESTAMP_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TIMESTAMP_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.COURSE_TYPE_ERROR:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.COURSE_TYPE_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.FLOAT_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.FLOAT_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.GOOD_STOCKUM_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.GOOD_STOCKUM_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.GOOD_CLASS_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.GOOD_CLASS_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.GOOD_DEDUCT_STOCKUM_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.GOOD_DEDUCT_STOCKUM_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.GOOD_EXCHANGE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.GOOD_EXCHANGE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.TIME_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.TIME_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.PROJECT_CODE_OF_MUTI_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.PROJECT_CODE_OF_MUTI_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.OPEN_STATUS_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.OPEN_STATUS_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ORDER_ORDER_NOT_EXIST_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ORDER_ORDER_NOT_EXIST_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ORDER_REFUND_ORDER_NOT_EXIST_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ORDER_REFUND_ORDER_NOT_EXIST_MSG);
				return JSON.toJSONString(map);

			case CodeUtils.ORDER_ORDER_DEPOSIT_NOT_EXIST_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ORDER_ORDER_DEPOSIT_NOT_EXIST_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ORDER_REFUND_ORDER_EXIST_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.ORDER_REFUND_ORDER_EXIST_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.APPOINT_STATUS_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.APPOINT_STATUS_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.DUPLICATE_UNIQUE_KEY_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.DUPLICATE_UNIQUE_KEY_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.GOOD_STOCKUM_STATUS_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.GOOD_STOCKUM_STATUS_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.GOOD_NON_EXISTENT_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.GOOD_NON_EXISTENT_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.APPOINT_TYPE_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.APPOINT_TYPE_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.SCORE_TYPE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.SCORE_TYPE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.CLASS_STOCKUM_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.CLASS_STOCKUM_MSG);
			case CodeUtils.RANGE_ERROR:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.RANGE_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.REPEAT_BUY_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.REPEAT_BUY_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.REPEAT_EXCHANGE_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.REPEAT_EXCHANGE_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.APPOINT_STATUS_MUTY_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.APPOINT_STATUS_MUTY_ERROR_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.CLASS_DEDUCT_STOCKUM_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.CLASS_DEDUCT_STOCKUM_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.UPDATE_STOCKUM_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.UPDATE_STOCKUM_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.GOOD_STATUS_CODE:
				map.put("code", errorCode);
				map.put("message", field + " " + CodeUtils.GOOD_STATUS_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ONE_TWO_ERROR:
				map.put("code", errorCode);
				map.put("message", field + " " + "只能为1或2");
				return JSON.toJSONString(map);
			case CodeUtils.PAGEZISE_RANGE_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", String.format("%s %s", field, CodeUtils.PAGEZISE_RANGE_ERROR_MSG));
				return JSON.toJSONString(map);
			case CodeUtils.MULTI_ID_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", String.format("%s %s", field, CodeUtils.MULTI_ID_ERROR_MSG));
				return JSON.toJSONString(map);
			case CodeUtils.APPKEY_SIZE_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", String.format("%s %s", field, CodeUtils.APPKEY_SIZE_ERROR_MSG));
				return JSON.toJSONString(map);
			case CodeUtils.GOODS_SELLER_ID_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message", String.format("%s %s", field, CodeUtils.GOODS_SELLER_ID_ERROR_CODE));
				return JSON.toJSONString(map);
			case CodeUtils.APPOINT_EXCHANGE_STUDENT_EROOR_CODE:
				map.put("code", errorCode);
				map.put("message", String.format("%s %s", field, CodeUtils.APPOINT_EXCHANGE_STUDENT_EROOR_MSG));
				return JSON.toJSONString(map);
			case CodeUtils.GOODS_CLASS_EMPTY_CODE:
				map.put("code", errorCode);
				map.put("message",field + " "+CodeUtils.GOODS_CLASS_EMPTY_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.USER_ASSETS_SORT_BY_REGEX_CODE:
				map.put("code", errorCode);
				map.put("message",field + " "+CodeUtils.USER_ASSETS_SORT_BY_REGEX_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.ASSETS_SKU_TYPE_REGEX_CODE:
				map.put("code", errorCode);
				map.put("message",field + " "+CodeUtils.ASSETS_SKU_TYPE_REGEX_MSG);
				return JSON.toJSONString(map);
			case CodeUtils.SORTBY_COLUMN_ERROR_CODE:
				map.put("code", errorCode);
				map.put("message",field + " "+CodeUtils.SORTBY_COLUMN_ERROR_MSG);
				return JSON.toJSONString(map);
			default:
				map.put("code", DATA_WRONGFULNESS_CODE);
				map.put("message", field + " " + CodeUtils.DATA_WRONGFULNESS_MSG);
				return JSON.toJSONString(map);
		}
	}
}
