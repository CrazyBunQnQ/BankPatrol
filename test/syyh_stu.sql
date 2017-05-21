-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017-05-21 13:05:23
-- 服务器版本： 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `syyh_stu`
--

-- --------------------------------------------------------

--
-- 表的结构 `bank`
--

CREATE TABLE `bank` (
  `Bank_id` varchar(10) NOT NULL,
  `Bank_Name` varchar(40) DEFAULT NULL,
  `Bank_Longitude` decimal(15,10) DEFAULT NULL,
  `Bank_Latitude` decimal(15,10) DEFAULT NULL,
  `Bank_IP` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `bank`
--

INSERT INTO `bank` (`Bank_id`, `Bank_Name`, `Bank_Longitude`, `Bank_Latitude`, `Bank_IP`) VALUES
('00001', 'XX银行XXX支行', '120.0000000000', '40.0000000000', '111.111.111.111'),
('00002', '超级零零二银行', '37.7870700000', '-122.4944930000', '123.23.14.95'),
('00003', '我是第三银行', '37.7874870000', '-122.1548640000', '123.215.147.23'),
('00004', '四四四银行', '12.1564560000', '21.1654900000', '123.164.154.44'),
('00005', '呜呜呜银行', '21.1654600000', '-123.5465400000', '123.15.156.52'),
('00006', '凯西银行', '-122.4760195900', '37.7244047000', '5646465'),
('00007', '化石翼龙银行', '-122.4243394000', '37.7758735000', '546546'),
('00008', '吉利蛋银行', '-122.4209171000', '37.7915260000', '123456'),
('00009', '迷你龙银行', '-122.5074650000', '37.7453927000', '13246549'),
('00010', '伊布银行', '-122.4371310000', '37.7712796000', '1231234'),
('00011', '鬼斯银行', '-122.4591836000', '37.7856790000', '2134551'),
('00012', '胖丁银行', '-122.4407079000', '37.7432146000', '123123'),
('00013', '天龙银行地龙支行', '123.2000000000', '78.1000000000', '123.123.123.123'),
('00014', '化石盔银行', '-122.4297298000', '37.7851818000', '1234124'),
('00015', '乘龙银行', '-122.5124988000', '37.7740354000', '12323'),
('00016', '大舌头银行', '-122.4058221000', '37.8023949000', '123123123'),
('00017', '腕力银行', '-122.4130288000', '37.7943426000', '132165');

-- --------------------------------------------------------

--
-- 表的结构 `bankequipment`
--

CREATE TABLE `bankequipment` (
  `EquipmentEach_ID` varchar(10) NOT NULL,
  `Equipment_id` varchar(10) DEFAULT NULL,
  `Bank_id` varchar(10) DEFAULT NULL,
  `Equipment_Value` decimal(10,2) DEFAULT NULL,
  `Equipment_BuyDate` date DEFAULT NULL,
  `Status` char(1) DEFAULT NULL,
  `Depreciation_Value` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `bankequipment`
--

INSERT INTO `bankequipment` (`EquipmentEach_ID`, `Equipment_id`, `Bank_id`, `Equipment_Value`, `Equipment_BuyDate`, `Status`, `Depreciation_Value`) VALUES
('00001', '001', '00001', '5000.00', '2015-08-04', '0', '3000.00'),
('00002', '001', '00001', '13216.00', '2017-05-16', '0', '1635.00'),
('asdff45646', '002', '00001', '5000.00', '2017-05-16', '0', '3111.00');

-- --------------------------------------------------------

--
-- 表的结构 `department`
--

CREATE TABLE `department` (
  `Department_id` bigint(20) NOT NULL,
  `Department_Name` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `department`
--

INSERT INTO `department` (`Department_id`, `Department_Name`) VALUES
(1, '董事会'),
(2, '网点行长'),
(3, '理财经理'),
(4, '柜员'),
(5, '大堂经理'),
(6, '个贷客户经理'),
(7, '营业主管'),
(8, '零售银行部'),
(9, '私人银行部'),
(10, '公司银行部'),
(11, '基盘业务部门'),
(16, '人力资源部门'),
(17, '巡检中心');

-- --------------------------------------------------------

--
-- 表的结构 `equipmentmaintain`
--

CREATE TABLE `equipmentmaintain` (
  `Maintain_ID` bigint(20) NOT NULL,
  `EquipmentEach_ID` varchar(10) DEFAULT NULL,
  `Maintain_Date` date DEFAULT NULL,
  `Maintain_Result` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `equipmenttype`
--

CREATE TABLE `equipmenttype` (
  `Equipment_id` varchar(10) NOT NULL,
  `Equipment_Name` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `equipmenttype`
--

INSERT INTO `equipmenttype` (`Equipment_id`, `Equipment_Name`) VALUES
('001', '打印机'),
('002', 'ATM'),
('003', '复印件'),
('004', '复印机');

-- --------------------------------------------------------

--
-- 表的结构 `faultrepairtype`
--

CREATE TABLE `faultrepairtype` (
  `Pitype_ID` bigint(20) NOT NULL,
  `PITYPE_Value` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `faultrepairtype`
--

INSERT INTO `faultrepairtype` (`Pitype_ID`, `PITYPE_Value`) VALUES
(14, '打印机缺墨'),
(15, '打印机卡纸'),
(16, 'ATM机不吐钞');

-- --------------------------------------------------------

--
-- 表的结构 `fault_repair`
--

CREATE TABLE `fault_repair` (
  `Repair_ID` bigint(20) NOT NULL,
  `Group_ID` bigint(20) DEFAULT NULL,
  `EquipmentEach_ID` varchar(10) DEFAULT NULL,
  `Pitype_ID` bigint(20) DEFAULT NULL,
  `Equipment_ID` varchar(10) DEFAULT NULL,
  `Bank_ID` varchar(10) DEFAULT NULL,
  `Login_ID` varchar(10) DEFAULT NULL,
  `Fault_Repair_Begin_Date` date DEFAULT NULL,
  `Repair_Status` char(1) DEFAULT NULL,
  `Allocate_Status` char(1) DEFAULT NULL,
  `Fault_Repair_End_Date` date DEFAULT NULL,
  `Fault_Repair_Evaluation` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `functions`
--

CREATE TABLE `functions` (
  `Func_ID` bigint(20) NOT NULL,
  `Func_Name` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `functions`
--

INSERT INTO `functions` (`Func_ID`, `Func_Name`) VALUES
(1, '系统管理'),
(2, '报修管理'),
(3, '巡检管理');

-- --------------------------------------------------------

--
-- 表的结构 `globals`
--

CREATE TABLE `globals` (
  `Global_id` bigint(20) NOT NULL,
  `Key_1` varchar(10) DEFAULT NULL,
  `Value_1` varchar(30) DEFAULT NULL,
  `Key_2` varchar(10) DEFAULT NULL,
  `Value_2` varchar(30) DEFAULT NULL,
  `Key_3` varchar(10) DEFAULT NULL,
  `Value_3` varchar(30) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `gwym`
--

CREATE TABLE `gwym` (
  `Job_ID` bigint(20) NOT NULL,
  `ymbh` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `gwym`
--

INSERT INTO `gwym` (`Job_ID`, `ymbh`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(2, 4),
(2, 6),
(2, 8),
(2, 10),
(2, 11),
(2, 15),
(2, 17),
(2, 19),
(3, 7),
(3, 12),
(3, 13),
(3, 15),
(3, 16),
(3, 19),
(4, 15),
(4, 18),
(4, 19);

-- --------------------------------------------------------

--
-- 表的结构 `job`
--

CREATE TABLE `job` (
  `Job_ID` bigint(20) NOT NULL,
  `Name` varchar(40) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `job`
--

INSERT INTO `job` (`Job_ID`, `Name`, `Description`) VALUES
(1, '高级管理员', '本系统最高权限的用户'),
(2, '巡检中心管理员', '巡检中心管理员'),
(3, '银行网点管理员', '每个银行都会用对应的管理员'),
(4, '巡检工', '巡检工');

-- --------------------------------------------------------

--
-- 表的结构 `logs`
--

CREATE TABLE `logs` (
  `log_ID` bigint(20) NOT NULL,
  `Checkin_time` datetime DEFAULT NULL,
  `Checkout_time` datetime DEFAULT NULL,
  `Users_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `logs`
--

INSERT INTO `logs` (`log_ID`, `Checkin_time`, `Checkout_time`, `Users_ID`) VALUES
(129, '2017-04-05 14:34:14', '2017-04-05 14:34:15', 'admin'),
(130, '2017-04-05 14:34:16', '2017-04-05 14:34:17', 'admin'),
(131, '2017-04-05 14:34:18', '2017-04-05 14:34:19', 'admin'),
(132, '2017-04-05 14:34:20', '2017-04-05 14:34:21', 'admin'),
(133, '2017-04-05 14:34:22', '2017-04-05 14:34:23', 'admin'),
(134, '2017-04-05 14:34:23', '2017-04-05 14:34:24', 'admin'),
(135, '2017-04-05 14:34:26', NULL, 'admin'),
(136, '2017-04-21 10:49:11', NULL, 'admin'),
(137, '2017-04-21 11:34:37', NULL, 'admin'),
(138, '2017-04-25 09:34:33', NULL, 'admin'),
(139, '2017-04-25 09:36:29', NULL, 'admin'),
(140, '2017-04-25 10:35:05', NULL, 'admin'),
(141, '2017-04-25 10:53:44', NULL, 'admin'),
(142, '2017-04-25 11:34:25', NULL, 'admin'),
(143, '2017-04-25 00:00:00', NULL, 'admin'),
(144, '2017-04-25 00:00:00', NULL, 'admin'),
(145, '2017-04-25 00:00:00', NULL, 'admin'),
(146, '2017-04-26 00:00:00', NULL, 'admin'),
(147, '2017-04-26 00:00:00', NULL, 'admin'),
(148, '2017-04-26 00:00:00', NULL, 'admin'),
(149, '2017-04-26 00:00:00', NULL, 'admin'),
(150, '2017-04-26 00:00:00', NULL, 'admin'),
(151, '2017-04-26 00:00:00', NULL, 'admin'),
(152, '2017-04-26 00:00:00', NULL, 'admin'),
(153, '2017-04-26 00:00:00', NULL, 'admin'),
(154, '2017-04-26 00:00:00', NULL, 'admin'),
(155, '2017-04-26 00:00:00', NULL, '1'),
(156, '2017-04-26 00:00:00', NULL, '1'),
(157, '2017-04-26 00:00:00', NULL, '1'),
(158, '2017-04-26 00:00:00', NULL, '2'),
(159, '2017-04-26 00:00:00', NULL, '2'),
(160, '2017-04-26 00:00:00', NULL, '2'),
(161, '2017-04-26 00:00:00', NULL, '1'),
(162, '2017-04-26 00:00:00', NULL, '1'),
(163, '2017-04-26 00:00:00', NULL, 'admin'),
(164, '2017-04-26 00:00:00', '2017-04-26 00:00:00', '1'),
(165, '2017-04-26 00:00:00', '2017-04-26 00:00:00', 'admin'),
(166, '2017-04-26 00:00:00', '2017-04-26 00:00:00', '1'),
(167, '2017-04-26 00:00:00', NULL, '1'),
(168, '2017-04-26 00:00:00', '2017-04-26 00:00:00', 'admin'),
(169, '2017-04-26 00:00:00', '2017-04-26 00:00:00', '1'),
(170, '2017-04-26 00:00:00', NULL, '1'),
(171, '2017-04-26 00:00:00', '2017-04-26 00:00:00', 'admin'),
(172, '2017-04-26 00:00:00', NULL, '1'),
(173, '2017-04-26 00:00:00', NULL, '1'),
(174, '2017-04-26 00:00:00', NULL, '1'),
(175, '2017-04-26 00:00:00', NULL, '1'),
(176, '2017-04-26 00:00:00', NULL, '1'),
(177, '2017-04-26 00:00:00', '2017-04-26 00:00:00', 'admin'),
(178, '2017-04-26 00:00:00', NULL, '1'),
(179, '2017-04-26 00:00:00', '2017-04-26 00:00:00', 'admin'),
(180, '2017-04-26 00:00:00', NULL, '1'),
(181, '2017-04-29 00:00:00', NULL, 'admin'),
(182, '2017-05-08 00:00:00', NULL, 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `piequipmenttable`
--

CREATE TABLE `piequipmenttable` (
  `ID` bigint(20) NOT NULL,
  `Login_ID` varchar(10) DEFAULT NULL,
  `Bank_ID` varchar(10) DEFAULT NULL,
  `Group_ID` bigint(20) DEFAULT NULL,
  `Equipment_ID` varchar(10) DEFAULT NULL,
  `Pitype_ID` bigint(20) DEFAULT NULL,
  `EquipmentEach_ID` varchar(10) DEFAULT NULL,
  `PI_Date` date DEFAULT NULL,
  `PI_Evaluation` varchar(255) DEFAULT NULL,
  `PI_Status` char(1) DEFAULT NULL,
  `Status` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `pigroup`
--

CREATE TABLE `pigroup` (
  `Group_ID` bigint(20) NOT NULL,
  `Group_Name` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `pigroup`
--

INSERT INTO `pigroup` (`Group_ID`, `Group_Name`) VALUES
(1, 'A组'),
(2, 'B组'),
(3, 'C组'),
(4, 'D组'),
(5, 'F组'),
(6, 'E组'),
(7, 'D组'),
(8, 'D组'),
(9, 'D组'),
(10, 'D组'),
(11, 'D组'),
(12, 'D组'),
(13, 'D组'),
(14, 'D组');

-- --------------------------------------------------------

--
-- 表的结构 `piworker`
--

CREATE TABLE `piworker` (
  `Worker_ID` bigint(20) NOT NULL,
  `Group_ID` bigint(20) DEFAULT NULL,
  `Worker_Tel1` varchar(40) DEFAULT NULL,
  `Worker_Tel2` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `piworker`
--

INSERT INTO `piworker` (`Worker_ID`, `Group_ID`, `Worker_Tel1`, `Worker_Tel2`) VALUES
(1, 3, '13159899293', '15546229592'),
(2, 3, '13877889541', '15634542114');

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE `users` (
  `Login_ID` varchar(10) NOT NULL,
  `Job_ID` bigint(20) DEFAULT NULL,
  `Department_ID` bigint(20) DEFAULT NULL,
  `Login_Password` varchar(32) DEFAULT NULL,
  `User_Name` varchar(40) DEFAULT NULL,
  `User_Status` char(1) DEFAULT NULL,
  `Worker_ID` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`Login_ID`, `Job_ID`, `Department_ID`, `Login_Password`, `User_Name`, `User_Status`, `Worker_ID`) VALUES
('admin', 1, 1, 'E10ADC3949BA59ABBE56E057F20F883E', 'admin', '1', NULL),
('test', 2, 17, 'E10ADC3949BA59ABBE56E057F20F883E', '测试', '1', NULL),
('test1', 1, 1, 'E10ADC3949BA59ABBE56E057F20F883E', '测试1', '1', NULL),
('test2', 3, 17, 'E10ADC3949BA59ABBE56E057F20F883E', '测试2', '1', NULL),
('test3', 2, 17, 'E10ADC3949BA59ABBE56E057F20F883E', '测试3', '1', NULL),
('test4', 1, 1, 'E10ADC3949BA59ABBE56E057F20F883E', '测试4', '1', NULL),
('test5', 1, 1, 'E10ADC3949BA59ABBE56E057F20F883E', '测试5', '1', NULL),
('test6', 1, 1, 'E10ADC3949BA59ABBE56E057F20F883E', '测试6', '1', NULL),
('xj1', 4, 17, 'E10ADC3949BA59ABBE56E057F20F883E', '巡检工1', '1', 1),
('xj2', 4, 17, 'E10ADC3949BA59ABBE56E057F20F883E', '巡检工2', '1', 2);

-- --------------------------------------------------------

--
-- 表的结构 `xtymb`
--

CREATE TABLE `xtymb` (
  `ymbh` bigint(20) NOT NULL,
  `Func_ID` bigint(20) DEFAULT NULL,
  `ymmc` varchar(20) DEFAULT NULL,
  `URL` varchar(200) DEFAULT NULL,
  `IMG` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `xtymb`
--

INSERT INTO `xtymb` (`ymbh`, `Func_ID`, `ymmc`, `URL`, `IMG`) VALUES
(1, 1, '用户管理', 'user/list', NULL),
(2, 1, '部门管理', 'dept/deptList', NULL),
(3, 1, '日志管理', 'log/logList', NULL),
(4, 1, '银行设备种类管理', 'etype/equipmentTypeList', NULL),
(5, 1, '全局变量管理', '../xtgl/globalsList', NULL),
(6, 1, '银行网点管理', 'bank/bankList', NULL),
(7, 2, '网点查看报修信息', '../sbbx/sbbx!listw', NULL),
(8, 2, '巡检中心查看报修信息', '../sbbx/sbbx!list', NULL),
(9, 1, '岗位管理', 'job/jobList?first=1', NULL),
(10, 1, '巡检工管理', 'piwoker/piwokerList', NULL),
(11, 1, '巡检组管理', 'pigroup/pigrouplist', NULL),
(12, 1, '设备问题报修管理', 'frt/frtlist', NULL),
(13, 2, '网点设备报修', '../sbbx/sbbx!presavew', NULL),
(14, 2, '值班员报修', '../sbbx/sbbx!presavez', NULL),
(15, 3, '网点对巡检确认', 'inspection/wdryList', NULL),
(16, 2, '网点对报修确认', '../sbbx/sbbx!listw?rs=1', NULL),
(17, 2, '巡检中心分配小组', '../sbbx/sbbx!list?rs=0&as=0', NULL),
(18, 2, '维修工确认维修', '../sbbx/sbbx!listg', NULL),
(19, 3, '设备巡检', 'inspection/sbxjList?y=n', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`Bank_id`);

--
-- Indexes for table `bankequipment`
--
ALTER TABLE `bankequipment`
  ADD PRIMARY KEY (`EquipmentEach_ID`),
  ADD KEY `FK_BANK_EQU_BANDEQUME_BANK` (`Bank_id`),
  ADD KEY `FK47E14B4BEA58C9D5` (`Equipment_id`),
  ADD KEY `FK47E14B4B2E8E7C79` (`Bank_id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`Department_id`);

--
-- Indexes for table `equipmentmaintain`
--
ALTER TABLE `equipmentmaintain`
  ADD PRIMARY KEY (`Maintain_ID`),
  ADD KEY `FK_EQUIPMEN_BANKEQUIP_BANK_EQU` (`EquipmentEach_ID`),
  ADD KEY `FK9DF62D19C0DBB81E` (`EquipmentEach_ID`);

--
-- Indexes for table `equipmenttype`
--
ALTER TABLE `equipmenttype`
  ADD PRIMARY KEY (`Equipment_id`);

--
-- Indexes for table `faultrepairtype`
--
ALTER TABLE `faultrepairtype`
  ADD PRIMARY KEY (`Pitype_ID`);

--
-- Indexes for table `fault_repair`
--
ALTER TABLE `fault_repair`
  ADD PRIMARY KEY (`Repair_ID`),
  ADD KEY `FK_FAULT_RE_RELATIONS_FAULT_RE` (`Pitype_ID`),
  ADD KEY `FK29A3984AC0DBB81E` (`EquipmentEach_ID`),
  ADD KEY `FK29A3984AEA58C9D5` (`Equipment_ID`),
  ADD KEY `FK29A3984A8BB06F5A` (`Login_ID`),
  ADD KEY `FK29A3984A2E8E7C79` (`Bank_ID`),
  ADD KEY `FK29A3984ACC79E242` (`Group_ID`),
  ADD KEY `FK29A3984A32646EB1` (`Pitype_ID`);

--
-- Indexes for table `functions`
--
ALTER TABLE `functions`
  ADD PRIMARY KEY (`Func_ID`);

--
-- Indexes for table `globals`
--
ALTER TABLE `globals`
  ADD PRIMARY KEY (`Global_id`);

--
-- Indexes for table `gwym`
--
ALTER TABLE `gwym`
  ADD PRIMARY KEY (`Job_ID`,`ymbh`),
  ADD KEY `FK30A00413833D4D` (`ymbh`),
  ADD KEY `FK30A0047A4F47B` (`Job_ID`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`Job_ID`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_ID`);

--
-- Indexes for table `piequipmenttable`
--
ALTER TABLE `piequipmenttable`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_PI_EQUIP_RELATIONS_FAULT_RE` (`Pitype_ID`),
  ADD KEY `FK4E9F397C0DBB81E` (`EquipmentEach_ID`),
  ADD KEY `FK4E9F397EA58C9D5` (`Equipment_ID`),
  ADD KEY `FK4E9F3978BB06F5A` (`Login_ID`),
  ADD KEY `FK4E9F3972E8E7C79` (`Bank_ID`),
  ADD KEY `FK4E9F397CC79E242` (`Group_ID`),
  ADD KEY `FK4E9F39732646EB1` (`Pitype_ID`);

--
-- Indexes for table `pigroup`
--
ALTER TABLE `pigroup`
  ADD PRIMARY KEY (`Group_ID`);

--
-- Indexes for table `piworker`
--
ALTER TABLE `piworker`
  ADD PRIMARY KEY (`Worker_ID`),
  ADD KEY `FK_PIWOKER_GROUPWORK_PI_GROUP` (`Group_ID`),
  ADD KEY `FKDEA7C627CC79E242` (`Group_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Login_ID`),
  ADD KEY `FK_USERS_JOBUSER_JOB` (`Job_ID`),
  ADD KEY `FK6A68E087448F179` (`Department_ID`),
  ADD KEY `FK6A68E087A4F47B` (`Job_ID`),
  ADD KEY `FK55A6555555677V` (`Worker_ID`);

--
-- Indexes for table `xtymb`
--
ALTER TABLE `xtymb`
  ADD PRIMARY KEY (`ymbh`),
  ADD KEY `FK_XTYMB_RELATIONS_FUNCTION` (`Func_ID`),
  ADD KEY `FK6D19352345A7B32` (`Func_ID`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `department`
--
ALTER TABLE `department`
  MODIFY `Department_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- 使用表AUTO_INCREMENT `faultrepairtype`
--
ALTER TABLE `faultrepairtype`
  MODIFY `Pitype_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- 使用表AUTO_INCREMENT `fault_repair`
--
ALTER TABLE `fault_repair`
  MODIFY `Repair_ID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `job`
--
ALTER TABLE `job`
  MODIFY `Job_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- 使用表AUTO_INCREMENT `logs`
--
ALTER TABLE `logs`
  MODIFY `log_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=183;
--
-- 使用表AUTO_INCREMENT `pigroup`
--
ALTER TABLE `pigroup`
  MODIFY `Group_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- 使用表AUTO_INCREMENT `piworker`
--
ALTER TABLE `piworker`
  MODIFY `Worker_ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 限制导出的表
--

--
-- 限制表 `bankequipment`
--
ALTER TABLE `bankequipment`
  ADD CONSTRAINT `FK_BANK_EQU_BANDEQUME_BANK` FOREIGN KEY (`Bank_id`) REFERENCES `bank` (`Bank_id`),
  ADD CONSTRAINT `FK_BANK_EQU_ZLMX_EQUIPMEN` FOREIGN KEY (`Equipment_id`) REFERENCES `equipmenttype` (`Equipment_id`);

--
-- 限制表 `equipmentmaintain`
--
ALTER TABLE `equipmentmaintain`
  ADD CONSTRAINT `FK_EQUIPMEN_BANKEQUIP_BANK_EQU` FOREIGN KEY (`EquipmentEach_ID`) REFERENCES `bankequipment` (`EquipmentEach_ID`);

--
-- 限制表 `fault_repair`
--
ALTER TABLE `fault_repair`
  ADD CONSTRAINT `FK_FAULT_RE_BANK_EQUI_BANK_EQU` FOREIGN KEY (`EquipmentEach_ID`) REFERENCES `bankequipment` (`EquipmentEach_ID`),
  ADD CONSTRAINT `FK_FAULT_RE_PI_GRUOP__PI_GROUP` FOREIGN KEY (`Group_ID`) REFERENCES `pigroup` (`Group_id`),
  ADD CONSTRAINT `FK_FAULT_RE_RELATIONS_BANK` FOREIGN KEY (`Bank_ID`) REFERENCES `bank` (`Bank_id`),
  ADD CONSTRAINT `FK_FAULT_RE_RELATIONS_EQUIPMEN` FOREIGN KEY (`Equipment_ID`) REFERENCES `equipmenttype` (`Equipment_id`),
  ADD CONSTRAINT `FK_FAULT_RE_RELATIONS_FAULT_RE` FOREIGN KEY (`Pitype_ID`) REFERENCES `faultrepairtype` (`Pitype_ID`),
  ADD CONSTRAINT `FK_FAULT_RE_USER_FAUL_USERS` FOREIGN KEY (`Login_ID`) REFERENCES `users` (`Login_ID`);

--
-- 限制表 `gwym`
--
ALTER TABLE `gwym`
  ADD CONSTRAINT `FK_GWYM_GWYM2_XTYMB` FOREIGN KEY (`ymbh`) REFERENCES `xtymb` (`ymbh`),
  ADD CONSTRAINT `FK_JOBid` FOREIGN KEY (`Job_ID`) REFERENCES `job` (`Job_ID`);

--
-- 限制表 `piequipmenttable`
--
ALTER TABLE `piequipmenttable`
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_BANK` FOREIGN KEY (`Bank_ID`) REFERENCES `bank` (`Bank_id`),
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_BANK_EQU` FOREIGN KEY (`EquipmentEach_ID`) REFERENCES `bankequipment` (`EquipmentEach_ID`),
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_EQUIPMEN` FOREIGN KEY (`Equipment_ID`) REFERENCES `equipmenttype` (`Equipment_id`),
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_FAULT_RE` FOREIGN KEY (`Pitype_ID`) REFERENCES `faultrepairtype` (`Pitype_ID`),
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_PI_GROUP` FOREIGN KEY (`Group_ID`) REFERENCES `pigroup` (`Group_id`),
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_USERS` FOREIGN KEY (`Login_ID`) REFERENCES `users` (`Login_ID`);

--
-- 限制表 `piworker`
--
ALTER TABLE `piworker`
  ADD CONSTRAINT `FK_PIWOKER_GROUPWORK_PI_GROUP` FOREIGN KEY (`Group_ID`) REFERENCES `pigroup` (`Group_ID`);

--
-- 限制表 `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK55A6555555677V` FOREIGN KEY (`Worker_ID`) REFERENCES `piworker` (`Worker_ID`),
  ADD CONSTRAINT `FK6A68E087448F179` FOREIGN KEY (`Department_ID`) REFERENCES `department` (`Department_id`),
  ADD CONSTRAINT `FK6A68E087A4F47B` FOREIGN KEY (`Job_ID`) REFERENCES `job` (`Job_ID`);

--
-- 限制表 `xtymb`
--
ALTER TABLE `xtymb`
  ADD CONSTRAINT `FK_XTYMB_RELATIONS_FUNCTION` FOREIGN KEY (`Func_ID`) REFERENCES `functions` (`Func_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
