-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2017-05-05 09:19:01
-- 服务器版本： 5.5.53
-- PHP Version: 5.4.44

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bankpatrol`
--

-- --------------------------------------------------------

--
-- 表的结构 `bank`
--

CREATE TABLE IF NOT EXISTS `bank` (
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
('00001', 'XX银行XXX支行', '120.0000000000', '40.0000000000', '111.111.111.111');

-- --------------------------------------------------------

--
-- 表的结构 `bank_equipment`
--

CREATE TABLE IF NOT EXISTS `bank_equipment` (
  `EquipmentEach_ID` varchar(10) NOT NULL,
  `Equipment_id` varchar(10) DEFAULT NULL,
  `Bank_id` varchar(10) DEFAULT NULL,
  `Equipment_Value` decimal(10,2) DEFAULT NULL,
  `Equipment_BuyDate` date DEFAULT NULL,
  `Status` char(1) DEFAULT NULL,
  `Depreciation_Value` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `bank_equipment`
--

INSERT INTO `bank_equipment` (`EquipmentEach_ID`, `Equipment_id`, `Bank_id`, `Equipment_Value`, `Equipment_BuyDate`, `Status`, `Depreciation_Value`) VALUES
('00001', '001', '00001', '5000.00', '2015-08-04', '0', '3000.00');

-- --------------------------------------------------------

--
-- 表的结构 `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `Department_id` bigint(20) NOT NULL,
  `Department_Name` varchar(40) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

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
(11, '基盘业务部门');

-- --------------------------------------------------------

--
-- 表的结构 `equipmentmaintain`
--

CREATE TABLE IF NOT EXISTS `equipmentmaintain` (
  `Maintain_ID` bigint(20) NOT NULL,
  `EquipmentEach_ID` varchar(10) DEFAULT NULL,
  `Maintain_Date` date DEFAULT NULL,
  `Maintain_Result` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `equipmenttype`
--

CREATE TABLE IF NOT EXISTS `equipmenttype` (
  `Equipment_id` varchar(10) NOT NULL,
  `Equipment_Name` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `equipmenttype`
--

INSERT INTO `equipmenttype` (`Equipment_id`, `Equipment_Name`) VALUES
('001', '打印机'),
('002', 'ATM'),
('003', 'aaa'),
('004', '004');

-- --------------------------------------------------------

--
-- 表的结构 `fault_repair`
--

CREATE TABLE IF NOT EXISTS `fault_repair` (
  `RepairID` bigint(20) NOT NULL,
  `Group_id` bigint(20) DEFAULT NULL,
  `EquipmentEach_ID` varchar(10) DEFAULT NULL,
  `PITYPE_Id` bigint(20) DEFAULT NULL,
  `Equipment_id` varchar(10) DEFAULT NULL,
  `Bank_id` varchar(10) DEFAULT NULL,
  `Login_ID` varchar(10) DEFAULT NULL,
  `Fault_Repair_Begin_Date` date DEFAULT NULL,
  `Repair_Status` char(1) DEFAULT NULL,
  `Allocate_Status` char(1) DEFAULT NULL,
  `Fault_Repair_End_Date` date DEFAULT NULL,
  `Fault_Repair_Evaluation` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `fault_repair_type`
--

CREATE TABLE IF NOT EXISTS `fault_repair_type` (
  `PITYPE_Id` bigint(20) NOT NULL,
  `PITYPE_Value` varchar(40) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `fault_repair_type`
--

INSERT INTO `fault_repair_type` (`PITYPE_Id`, `PITYPE_Value`) VALUES
(1, '打印机故障');

-- --------------------------------------------------------

--
-- 表的结构 `functions`
--

CREATE TABLE IF NOT EXISTS `functions` (
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

CREATE TABLE IF NOT EXISTS `globals` (
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

CREATE TABLE IF NOT EXISTS `gwym` (
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
(1, 19);

-- --------------------------------------------------------

--
-- 表的结构 `job`
--

CREATE TABLE IF NOT EXISTS `job` (
  `Job_ID` bigint(20) NOT NULL,
  `Group_id` bigint(20) DEFAULT NULL,
  `Name` varchar(40) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `job`
--

INSERT INTO `job` (`Job_ID`, `Group_id`, `Name`, `Description`) VALUES
(1, NULL, '高级管理员', '测试功能'),
(2, NULL, 'test1', 'test1'),
(3, NULL, '123', '345'),
(4, NULL, '333', '444'),
(5, NULL, '666', '234');

-- --------------------------------------------------------

--
-- 表的结构 `logs`
--

CREATE TABLE IF NOT EXISTS `logs` (
  `log_id` bigint(20) NOT NULL,
  `Checkin_time` datetime DEFAULT NULL,
  `Checkout_time` datetime DEFAULT NULL,
  `Users_id` varchar(10) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `logs`
--

INSERT INTO `logs` (`log_id`, `Checkin_time`, `Checkout_time`, `Users_id`) VALUES
(1, '2016-08-30 16:42:47', NULL, 'admin'),
(2, '2016-08-30 17:13:29', NULL, 'admin'),
(3, '2016-08-30 17:31:47', NULL, 'admin'),
(4, '2016-08-31 09:02:55', NULL, 'admin'),
(5, '2016-08-31 15:16:10', NULL, 'admin'),
(6, '2016-08-31 16:27:02', NULL, 'admin'),
(7, '2016-08-31 16:56:06', NULL, 'admin'),
(8, '2016-09-01 14:37:52', NULL, 'admin'),
(9, '2016-09-01 14:45:16', NULL, 'admin'),
(10, '2016-09-01 15:04:50', NULL, 'admin'),
(11, '2016-09-01 16:01:23', NULL, 'admin'),
(12, '2016-09-01 17:28:31', NULL, 'admin'),
(13, '2016-09-01 17:46:43', NULL, 'admin'),
(14, '2016-09-01 17:49:46', NULL, 'admin'),
(15, '2016-09-02 16:18:36', NULL, 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `piwoker`
--

CREATE TABLE IF NOT EXISTS `piwoker` (
  `Woker_id` bigint(20) NOT NULL,
  `Group_id` bigint(20) DEFAULT NULL,
  `Worker_Name` varchar(40) DEFAULT NULL,
  `Worker_Tel_1` varchar(40) DEFAULT NULL,
  `Worker_Tel_2` varchar(40) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `piwoker`
--

INSERT INTO `piwoker` (`Woker_id`, `Group_id`, `Worker_Name`, `Worker_Tel_1`, `Worker_Tel_2`) VALUES
(1, 3, '张三', '13333333333', '13333333333');

-- --------------------------------------------------------

--
-- 表的结构 `pi_equipment_table`
--

CREATE TABLE IF NOT EXISTS `pi_equipment_table` (
  `ID` bigint(20) NOT NULL,
  `Login_ID` varchar(10) DEFAULT NULL,
  `Bank_id` varchar(10) DEFAULT NULL,
  `Group_id` bigint(20) DEFAULT NULL,
  `Equipment_id` varchar(10) DEFAULT NULL,
  `PITYPE_Id` bigint(20) DEFAULT NULL,
  `EquipmentEach_ID` varchar(10) DEFAULT NULL,
  `PI_Date` date DEFAULT NULL,
  `PI_Evaluation` varchar(255) DEFAULT NULL,
  `PI_Status` char(1) DEFAULT NULL,
  `Status` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `pi_group`
--

CREATE TABLE IF NOT EXISTS `pi_group` (
  `Group_id` bigint(20) NOT NULL,
  `Group_Name` varchar(40) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `pi_group`
--

INSERT INTO `pi_group` (`Group_id`, `Group_Name`) VALUES
(1, 'A组'),
(2, 'B组'),
(3, 'C组');

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `Login_ID` varchar(10) NOT NULL,
  `Job_ID` bigint(20) DEFAULT NULL,
  `Department_id` bigint(20) DEFAULT NULL,
  `Login_Password` varchar(30) DEFAULT NULL,
  `User_Name` varchar(40) DEFAULT NULL,
  `User_Status` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`Login_ID`, `Job_ID`, `Department_id`, `Login_Password`, `User_Name`, `User_Status`) VALUES
('admin', 1, 1, '123456', 'admin', '1'),
('test', 1, 2, '123456', '测试', '0'),
('test2', 2, 3, '123456', '测试2', '1'),
('test3', 1, 2, '123456', '测试3', '1'),
('test5', 2, 2, '123456', '测试5', '1'),
('test7', 1, 1, '123456', '测试7', '1');

-- --------------------------------------------------------

--
-- 表的结构 `xtymb`
--

CREATE TABLE IF NOT EXISTS `xtymb` (
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
(1, 1, '用户管理', 'user/userList.do', NULL),
(2, 1, '部门管理', 'dept/deptList.do', NULL),
(3, 1, '日志管理', 'log/logList.do', NULL),
(4, 1, '银行设备种类管理', 'equipmentType/equipmentTypeList.do', NULL),
(5, 1, '全局变量管理', '../xtgl/globalsList.do', NULL),
(6, 1, '银行网点管理', '../xtgl/banklist.do', NULL),
(7, 2, '网点查看报修信息', '../sbbx/sbbx!listw.do', NULL),
(8, 2, '巡检中心查看报修信息', '../sbbx/sbbx!list.do', NULL),
(9, 1, '岗位管理', 'job/jobList.do?first=1', NULL),
(10, 1, '巡检工管理', '../xtgl/Piwokerlist.do', NULL),
(11, 1, '巡检组管理', '../xtgl/PiGrouplist.do', NULL),
(12, 1, '设备问题报修管理', '../xtgl/frtlist.do', NULL),
(13, 2, '网点设备报修', '../sbbx/sbbx!presavew.do', NULL),
(14, 2, '值班员报修', '../sbbx/sbbx!presavez.do', NULL),
(15, 3, '网点对巡检确认', 'inspection/wdryList.do', NULL),
(16, 2, '网点对报修确认', '../sbbx/sbbx!listw.do?rs=1', NULL),
(17, 2, '巡检中心分配小组', '../sbbx/sbbx!list.do?rs=0&as=0', NULL),
(18, 2, '维修工确认维修', '../sbbx/sbbx!listg.do', NULL),
(19, 3, '设备巡检', 'inspection/sbxjList.do?y=n', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`Bank_id`);

--
-- Indexes for table `bank_equipment`
--
ALTER TABLE `bank_equipment`
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
-- Indexes for table `fault_repair`
--
ALTER TABLE `fault_repair`
  ADD PRIMARY KEY (`RepairID`),
  ADD KEY `FK_FAULT_RE_RELATIONS_FAULT_RE` (`PITYPE_Id`),
  ADD KEY `FK29A3984AC0DBB81E` (`EquipmentEach_ID`),
  ADD KEY `FK29A3984AEA58C9D5` (`Equipment_id`),
  ADD KEY `FK29A3984A8BB06F5A` (`Login_ID`),
  ADD KEY `FK29A3984A2E8E7C79` (`Bank_id`),
  ADD KEY `FK29A3984ACC79E242` (`Group_id`),
  ADD KEY `FK29A3984A32646EB1` (`PITYPE_Id`);

--
-- Indexes for table `fault_repair_type`
--
ALTER TABLE `fault_repair_type`
  ADD PRIMARY KEY (`PITYPE_Id`);

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
  ADD PRIMARY KEY (`Job_ID`),
  ADD KEY `FK_JOB_RELATIONS_PI_GROUP` (`Group_id`),
  ADD KEY `FK19BBDCC79E242` (`Group_id`);

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `piwoker`
--
ALTER TABLE `piwoker`
  ADD PRIMARY KEY (`Woker_id`),
  ADD KEY `FK_PIWOKER_GROUPWORK_PI_GROUP` (`Group_id`),
  ADD KEY `FKDEA7C627CC79E242` (`Group_id`);

--
-- Indexes for table `pi_equipment_table`
--
ALTER TABLE `pi_equipment_table`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_PI_EQUIP_RELATIONS_FAULT_RE` (`PITYPE_Id`),
  ADD KEY `FK4E9F397C0DBB81E` (`EquipmentEach_ID`),
  ADD KEY `FK4E9F397EA58C9D5` (`Equipment_id`),
  ADD KEY `FK4E9F3978BB06F5A` (`Login_ID`),
  ADD KEY `FK4E9F3972E8E7C79` (`Bank_id`),
  ADD KEY `FK4E9F397CC79E242` (`Group_id`),
  ADD KEY `FK4E9F39732646EB1` (`PITYPE_Id`);

--
-- Indexes for table `pi_group`
--
ALTER TABLE `pi_group`
  ADD PRIMARY KEY (`Group_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Login_ID`),
  ADD KEY `FK_USERS_JOBUSER_JOB` (`Job_ID`),
  ADD KEY `FK6A68E087448F179` (`Department_id`),
  ADD KEY `FK6A68E087A4F47B` (`Job_ID`);

--
-- Indexes for table `xtymb`
--
ALTER TABLE `xtymb`
  ADD PRIMARY KEY (`ymbh`),
  ADD KEY `FK_XTYMB_RELATIONS_FUNCTION` (`Func_ID`),
  ADD KEY `FK6D19352345A7B32` (`Func_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `Department_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `fault_repair`
--
ALTER TABLE `fault_repair`
  MODIFY `RepairID` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `fault_repair_type`
--
ALTER TABLE `fault_repair_type`
  MODIFY `PITYPE_Id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `job`
--
ALTER TABLE `job`
  MODIFY `Job_ID` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `piwoker`
--
ALTER TABLE `piwoker`
  MODIFY `Woker_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `pi_group`
--
ALTER TABLE `pi_group`
  MODIFY `Group_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- 限制导出的表
--

--
-- 限制表 `bank_equipment`
--
ALTER TABLE `bank_equipment`
  ADD CONSTRAINT `FK47E14B4B2E8E7C79` FOREIGN KEY (`Bank_id`) REFERENCES `bank` (`Bank_id`),
  ADD CONSTRAINT `FK47E14B4BEA58C9D5` FOREIGN KEY (`Equipment_id`) REFERENCES `equipmenttype` (`Equipment_id`),
  ADD CONSTRAINT `FK_BANK_EQU_BANDEQUME_BANK` FOREIGN KEY (`Bank_id`) REFERENCES `bank` (`Bank_id`),
  ADD CONSTRAINT `FK_BANK_EQU_ZLMX_EQUIPMEN` FOREIGN KEY (`Equipment_id`) REFERENCES `equipmenttype` (`Equipment_id`);

--
-- 限制表 `equipmentmaintain`
--
ALTER TABLE `equipmentmaintain`
  ADD CONSTRAINT `FK9DF62D19C0DBB81E` FOREIGN KEY (`EquipmentEach_ID`) REFERENCES `bank_equipment` (`EquipmentEach_ID`),
  ADD CONSTRAINT `FK_EQUIPMEN_BANKEQUIP_BANK_EQU` FOREIGN KEY (`EquipmentEach_ID`) REFERENCES `bank_equipment` (`EquipmentEach_ID`);

--
-- 限制表 `fault_repair`
--
ALTER TABLE `fault_repair`
  ADD CONSTRAINT `FK29A3984A2E8E7C79` FOREIGN KEY (`Bank_id`) REFERENCES `bank` (`Bank_id`),
  ADD CONSTRAINT `FK29A3984A32646EB1` FOREIGN KEY (`PITYPE_Id`) REFERENCES `fault_repair_type` (`PITYPE_Id`),
  ADD CONSTRAINT `FK29A3984A8BB06F5A` FOREIGN KEY (`Login_ID`) REFERENCES `users` (`Login_ID`),
  ADD CONSTRAINT `FK29A3984AC0DBB81E` FOREIGN KEY (`EquipmentEach_ID`) REFERENCES `bank_equipment` (`EquipmentEach_ID`),
  ADD CONSTRAINT `FK29A3984ACC79E242` FOREIGN KEY (`Group_id`) REFERENCES `pi_group` (`Group_id`),
  ADD CONSTRAINT `FK29A3984AEA58C9D5` FOREIGN KEY (`Equipment_id`) REFERENCES `equipmenttype` (`Equipment_id`),
  ADD CONSTRAINT `FK_FAULT_RE_BANK_EQUI_BANK_EQU` FOREIGN KEY (`EquipmentEach_ID`) REFERENCES `bank_equipment` (`EquipmentEach_ID`),
  ADD CONSTRAINT `FK_FAULT_RE_PI_GRUOP__PI_GROUP` FOREIGN KEY (`Group_id`) REFERENCES `pi_group` (`Group_id`),
  ADD CONSTRAINT `FK_FAULT_RE_RELATIONS_BANK` FOREIGN KEY (`Bank_id`) REFERENCES `bank` (`Bank_id`),
  ADD CONSTRAINT `FK_FAULT_RE_RELATIONS_EQUIPMEN` FOREIGN KEY (`Equipment_id`) REFERENCES `equipmenttype` (`Equipment_id`),
  ADD CONSTRAINT `FK_FAULT_RE_RELATIONS_FAULT_RE` FOREIGN KEY (`PITYPE_Id`) REFERENCES `fault_repair_type` (`PITYPE_Id`),
  ADD CONSTRAINT `FK_FAULT_RE_USER_FAUL_USERS` FOREIGN KEY (`Login_ID`) REFERENCES `users` (`Login_ID`);

--
-- 限制表 `gwym`
--
ALTER TABLE `gwym`
  ADD CONSTRAINT `FK30A00413833D4D` FOREIGN KEY (`ymbh`) REFERENCES `xtymb` (`ymbh`),
  ADD CONSTRAINT `FK30A0047A4F47B` FOREIGN KEY (`Job_ID`) REFERENCES `job` (`Job_ID`),
  ADD CONSTRAINT `FK_GWYM_GWYM2_XTYMB` FOREIGN KEY (`ymbh`) REFERENCES `xtymb` (`ymbh`),
  ADD CONSTRAINT `FK_GWYM_GWYM_JOB` FOREIGN KEY (`Job_ID`) REFERENCES `job` (`Job_ID`);

--
-- 限制表 `job`
--
ALTER TABLE `job`
  ADD CONSTRAINT `FK19BBDCC79E242` FOREIGN KEY (`Group_id`) REFERENCES `pi_group` (`Group_id`),
  ADD CONSTRAINT `FK_JOB_RELATIONS_PI_GROUP` FOREIGN KEY (`Group_id`) REFERENCES `pi_group` (`Group_id`);

--
-- 限制表 `piwoker`
--
ALTER TABLE `piwoker`
  ADD CONSTRAINT `FKDEA7C627CC79E242` FOREIGN KEY (`Group_id`) REFERENCES `pi_group` (`Group_id`),
  ADD CONSTRAINT `FK_PIWOKER_GROUPWORK_PI_GROUP` FOREIGN KEY (`Group_id`) REFERENCES `pi_group` (`Group_id`);

--
-- 限制表 `pi_equipment_table`
--
ALTER TABLE `pi_equipment_table`
  ADD CONSTRAINT `FK4E9F3972E8E7C79` FOREIGN KEY (`Bank_id`) REFERENCES `bank` (`Bank_id`),
  ADD CONSTRAINT `FK4E9F39732646EB1` FOREIGN KEY (`PITYPE_Id`) REFERENCES `fault_repair_type` (`PITYPE_Id`),
  ADD CONSTRAINT `FK4E9F3978BB06F5A` FOREIGN KEY (`Login_ID`) REFERENCES `users` (`Login_ID`),
  ADD CONSTRAINT `FK4E9F397C0DBB81E` FOREIGN KEY (`EquipmentEach_ID`) REFERENCES `bank_equipment` (`EquipmentEach_ID`),
  ADD CONSTRAINT `FK4E9F397CC79E242` FOREIGN KEY (`Group_id`) REFERENCES `pi_group` (`Group_id`),
  ADD CONSTRAINT `FK4E9F397EA58C9D5` FOREIGN KEY (`Equipment_id`) REFERENCES `equipmenttype` (`Equipment_id`),
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_BANK` FOREIGN KEY (`Bank_id`) REFERENCES `bank` (`Bank_id`),
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_BANK_EQU` FOREIGN KEY (`EquipmentEach_ID`) REFERENCES `bank_equipment` (`EquipmentEach_ID`),
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_EQUIPMEN` FOREIGN KEY (`Equipment_id`) REFERENCES `equipmenttype` (`Equipment_id`),
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_FAULT_RE` FOREIGN KEY (`PITYPE_Id`) REFERENCES `fault_repair_type` (`PITYPE_Id`),
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_PI_GROUP` FOREIGN KEY (`Group_id`) REFERENCES `pi_group` (`Group_id`),
  ADD CONSTRAINT `FK_PI_EQUIP_RELATIONS_USERS` FOREIGN KEY (`Login_ID`) REFERENCES `users` (`Login_ID`);

--
-- 限制表 `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK6A68E087448F179` FOREIGN KEY (`Department_id`) REFERENCES `department` (`Department_id`),
  ADD CONSTRAINT `FK6A68E087A4F47B` FOREIGN KEY (`Job_ID`) REFERENCES `job` (`Job_ID`),
  ADD CONSTRAINT `FK_USERS_DEPARTMEN_DEPARTME` FOREIGN KEY (`Department_id`) REFERENCES `department` (`Department_id`),
  ADD CONSTRAINT `FK_USERS_JOBUSER_JOB` FOREIGN KEY (`Job_ID`) REFERENCES `job` (`Job_ID`);

--
-- 限制表 `xtymb`
--
ALTER TABLE `xtymb`
  ADD CONSTRAINT `FK6D19352345A7B32` FOREIGN KEY (`Func_ID`) REFERENCES `functions` (`Func_ID`),
  ADD CONSTRAINT `FK_XTYMB_RELATIONS_FUNCTION` FOREIGN KEY (`Func_ID`) REFERENCES `functions` (`Func_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
