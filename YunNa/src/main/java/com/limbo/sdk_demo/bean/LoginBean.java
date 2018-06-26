package com.limbo.sdk_demo.bean;

/**
 * Created by wangqi on 2018/5/4.
 */

public class LoginBean {

    private MessageBean message;
    private RowsBean rows;
    private int total;

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }

    public RowsBean getRows() {
        return rows;
    }

    public void setRows(RowsBean rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public static class MessageBean {
        /**
         * code : 200
         * message : 操作成功！
         * stack : null
         */

        private int code;
        private String message;
        private Object stack;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getStack() {
            return stack;
        }

        public void setStack(Object stack) {
            this.stack = stack;
        }
    }

    public static class RowsBean {
        private Object address;
        private double addressLatitude;
        private double addressLongitude;
        private Object addressTime;
        private String avatar;
        private int beginNo;
        private Object birthday;
        private Object city;
        private CompanyBean company;
        private Object companyName;
        private Object dateTime;
        private Object dempartment;
        private Object departmentId;
        private Object departmentName;
        private Object duty;
        private Object email;
        private EmployeeBean employee;
        private Object employeeCode;
        private String employeeId;
        private int endNo;
        private Object engineerLevel;
        private String engineerStatus;
        private Object faultHandlExperie;
        private Object gender;
        private int genderNum;
        private Object isForeign;
        private Object job;
        private Object latitude;
        private Object lock;
        private Object longitude;
        private Object manageExperie;
        private int minute;
        private Object mobilePhone;
        private String name;
        private Object nowAddress;
        private Object officeTelephone;
        private Object oldpassword;
        private int overdueNumber;
        private String ownerCode;
        private String serviceProviderCode;
        private Object particiExperie;
        private Object pd;
        private Object personalProfile;
        private Object professionalSkills;
        private Object province;
        private Object region;
        private Object registerDate;
        private Object registerName;
        private String roleId;
        private Object roleName;
        private int rowNo;
        private Object sort;
        private Object sortKeyword;
        private String state;
        private Object technicalQualif;
        private Object technicalQualifName;
        private String token;
        private Object userCode;
        private int userCount;
        private Object userDesc;
        private Object userGroupId;
        private Object userGroupName;
        private String userId;
        private String userName;
        private Object userPwd;
        private Object versionCode;
        private int workOrderNumber;

        public String getServiceProviderCode() {
            return serviceProviderCode;
        }

        public void setServiceProviderCode(String serviceProviderCode) {
            this.serviceProviderCode = serviceProviderCode;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public double getAddressLatitude() {
            return addressLatitude;
        }

        public void setAddressLatitude(double addressLatitude) {
            this.addressLatitude = addressLatitude;
        }

        public double getAddressLongitude() {
            return addressLongitude;
        }

        public void setAddressLongitude(double addressLongitude) {
            this.addressLongitude = addressLongitude;
        }

        public Object getAddressTime() {
            return addressTime;
        }

        public void setAddressTime(Object addressTime) {
            this.addressTime = addressTime;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getBeginNo() {
            return beginNo;
        }

        public void setBeginNo(int beginNo) {
            this.beginNo = beginNo;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public CompanyBean getCompany() {
            return company;
        }

        public void setCompany(CompanyBean company) {
            this.company = company;
        }

        public Object getCompanyName() {
            return companyName;
        }

        public void setCompanyName(Object companyName) {
            this.companyName = companyName;
        }

        public Object getDateTime() {
            return dateTime;
        }

        public void setDateTime(Object dateTime) {
            this.dateTime = dateTime;
        }

        public Object getDempartment() {
            return dempartment;
        }

        public void setDempartment(Object dempartment) {
            this.dempartment = dempartment;
        }

        public Object getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Object departmentId) {
            this.departmentId = departmentId;
        }

        public Object getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(Object departmentName) {
            this.departmentName = departmentName;
        }

        public Object getDuty() {
            return duty;
        }

        public void setDuty(Object duty) {
            this.duty = duty;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public EmployeeBean getEmployee() {
            return employee;
        }

        public void setEmployee(EmployeeBean employee) {
            this.employee = employee;
        }

        public Object getEmployeeCode() {
            return employeeCode;
        }

        public void setEmployeeCode(Object employeeCode) {
            this.employeeCode = employeeCode;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public int getEndNo() {
            return endNo;
        }

        public void setEndNo(int endNo) {
            this.endNo = endNo;
        }

        public Object getEngineerLevel() {
            return engineerLevel;
        }

        public void setEngineerLevel(Object engineerLevel) {
            this.engineerLevel = engineerLevel;
        }

        public String getEngineerStatus() {
            return engineerStatus;
        }

        public void setEngineerStatus(String engineerStatus) {
            this.engineerStatus = engineerStatus;
        }

        public Object getFaultHandlExperie() {
            return faultHandlExperie;
        }

        public void setFaultHandlExperie(Object faultHandlExperie) {
            this.faultHandlExperie = faultHandlExperie;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public int getGenderNum() {
            return genderNum;
        }

        public void setGenderNum(int genderNum) {
            this.genderNum = genderNum;
        }

        public Object getIsForeign() {
            return isForeign;
        }

        public void setIsForeign(Object isForeign) {
            this.isForeign = isForeign;
        }

        public Object getJob() {
            return job;
        }

        public void setJob(Object job) {
            this.job = job;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLock() {
            return lock;
        }

        public void setLock(Object lock) {
            this.lock = lock;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public Object getManageExperie() {
            return manageExperie;
        }

        public void setManageExperie(Object manageExperie) {
            this.manageExperie = manageExperie;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public Object getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(Object mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getNowAddress() {
            return nowAddress;
        }

        public void setNowAddress(Object nowAddress) {
            this.nowAddress = nowAddress;
        }

        public Object getOfficeTelephone() {
            return officeTelephone;
        }

        public void setOfficeTelephone(Object officeTelephone) {
            this.officeTelephone = officeTelephone;
        }

        public Object getOldpassword() {
            return oldpassword;
        }

        public void setOldpassword(Object oldpassword) {
            this.oldpassword = oldpassword;
        }

        public int getOverdueNumber() {
            return overdueNumber;
        }

        public void setOverdueNumber(int overdueNumber) {
            this.overdueNumber = overdueNumber;
        }

        public String getOwnerCode() {
            return ownerCode;
        }

        public void setOwnerCode(String ownerCode) {
            this.ownerCode = ownerCode;
        }

        public Object getParticiExperie() {
            return particiExperie;
        }

        public void setParticiExperie(Object particiExperie) {
            this.particiExperie = particiExperie;
        }

        public Object getPd() {
            return pd;
        }

        public void setPd(Object pd) {
            this.pd = pd;
        }

        public Object getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(Object personalProfile) {
            this.personalProfile = personalProfile;
        }

        public Object getProfessionalSkills() {
            return professionalSkills;
        }

        public void setProfessionalSkills(Object professionalSkills) {
            this.professionalSkills = professionalSkills;
        }

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public Object getRegion() {
            return region;
        }

        public void setRegion(Object region) {
            this.region = region;
        }

        public Object getRegisterDate() {
            return registerDate;
        }

        public void setRegisterDate(Object registerDate) {
            this.registerDate = registerDate;
        }

        public Object getRegisterName() {
            return registerName;
        }

        public void setRegisterName(Object registerName) {
            this.registerName = registerName;
        }

        public String getRoleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public Object getRoleName() {
            return roleName;
        }

        public void setRoleName(Object roleName) {
            this.roleName = roleName;
        }

        public int getRowNo() {
            return rowNo;
        }

        public void setRowNo(int rowNo) {
            this.rowNo = rowNo;
        }

        public Object getSort() {
            return sort;
        }

        public void setSort(Object sort) {
            this.sort = sort;
        }

        public Object getSortKeyword() {
            return sortKeyword;
        }

        public void setSortKeyword(Object sortKeyword) {
            this.sortKeyword = sortKeyword;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Object getTechnicalQualif() {
            return technicalQualif;
        }

        public void setTechnicalQualif(Object technicalQualif) {
            this.technicalQualif = technicalQualif;
        }

        public Object getTechnicalQualifName() {
            return technicalQualifName;
        }

        public void setTechnicalQualifName(Object technicalQualifName) {
            this.technicalQualifName = technicalQualifName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Object getUserCode() {
            return userCode;
        }

        public void setUserCode(Object userCode) {
            this.userCode = userCode;
        }

        public int getUserCount() {
            return userCount;
        }

        public void setUserCount(int userCount) {
            this.userCount = userCount;
        }

        public Object getUserDesc() {
            return userDesc;
        }

        public void setUserDesc(Object userDesc) {
            this.userDesc = userDesc;
        }

        public Object getUserGroupId() {
            return userGroupId;
        }

        public void setUserGroupId(Object userGroupId) {
            this.userGroupId = userGroupId;
        }

        public Object getUserGroupName() {
            return userGroupName;
        }

        public void setUserGroupName(Object userGroupName) {
            this.userGroupName = userGroupName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getUserPwd() {
            return userPwd;
        }

        public void setUserPwd(Object userPwd) {
            this.userPwd = userPwd;
        }

        public Object getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(Object versionCode) {
            this.versionCode = versionCode;
        }

        public int getWorkOrderNumber() {
            return workOrderNumber;
        }

        public void setWorkOrderNumber(int workOrderNumber) {
            this.workOrderNumber = workOrderNumber;
        }

        public static class CompanyBean {

            private Object allWorkOrderCount;
            private int beginNo;
            private Object bufferingPeriodDate;
            private String businessScope;
            private String certificateNumber;
            private String certificateType;
            private Object certificationTime;
            private String checkFlag;
            private String checkSay;
            private String cityId;
            private Object cityName;
            private String companyCode;
            private int companyId;
            private String companyName;
            private String companyType;
            private String complainPhone;
            private String countryId;
            private Object countryName;
            private Object currentUserId;
            private String customerPhone;
            private Object deleteFlag;
            private String effectiveAge;
            private Object effectiveDate;
            private int endNo;
            private Object expirationDate;
            private Object failureDate;
            private String invitationCode;
            private Object lastLoggingTime;
            private double latitude;
            private String lawer;
            private double longitude;
            private String mail;
            private Object monthWorkOrderCount;
            private String provinceId;
            private Object provinceName;
            private String regionId;
            private Object regionName;
            private String registerAddr;
            private String registerCode;
            private String registerDate;
            private double registerMoney;
            private String registerName;
            private Object registerPhone;
            private int rowNo;
            private Object serverCount;
            private Object sort;
            private Object sortKeyword;
            private Object submitCertificationTime;
            private Object toFrom;
            private Object trialStatus;
            private String type;
            private Object userCount;
            private Object valibleEnd;
            private Object valibleStart;
            private String versionCode;
            private Object versionName;

            public Object getAllWorkOrderCount() {
                return allWorkOrderCount;
            }

            public void setAllWorkOrderCount(Object allWorkOrderCount) {
                this.allWorkOrderCount = allWorkOrderCount;
            }

            public int getBeginNo() {
                return beginNo;
            }

            public void setBeginNo(int beginNo) {
                this.beginNo = beginNo;
            }

            public Object getBufferingPeriodDate() {
                return bufferingPeriodDate;
            }

            public void setBufferingPeriodDate(Object bufferingPeriodDate) {
                this.bufferingPeriodDate = bufferingPeriodDate;
            }

            public String getBusinessScope() {
                return businessScope;
            }

            public void setBusinessScope(String businessScope) {
                this.businessScope = businessScope;
            }

            public String getCertificateNumber() {
                return certificateNumber;
            }

            public void setCertificateNumber(String certificateNumber) {
                this.certificateNumber = certificateNumber;
            }

            public String getCertificateType() {
                return certificateType;
            }

            public void setCertificateType(String certificateType) {
                this.certificateType = certificateType;
            }

            public Object getCertificationTime() {
                return certificationTime;
            }

            public void setCertificationTime(Object certificationTime) {
                this.certificationTime = certificationTime;
            }

            public String getCheckFlag() {
                return checkFlag;
            }

            public void setCheckFlag(String checkFlag) {
                this.checkFlag = checkFlag;
            }

            public String getCheckSay() {
                return checkSay;
            }

            public void setCheckSay(String checkSay) {
                this.checkSay = checkSay;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public Object getCityName() {
                return cityName;
            }

            public void setCityName(Object cityName) {
                this.cityName = cityName;
            }

            public String getCompanyCode() {
                return companyCode;
            }

            public void setCompanyCode(String companyCode) {
                this.companyCode = companyCode;
            }

            public int getCompanyId() {
                return companyId;
            }

            public void setCompanyId(int companyId) {
                this.companyId = companyId;
            }

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getCompanyType() {
                return companyType;
            }

            public void setCompanyType(String companyType) {
                this.companyType = companyType;
            }

            public String getComplainPhone() {
                return complainPhone;
            }

            public void setComplainPhone(String complainPhone) {
                this.complainPhone = complainPhone;
            }

            public String getCountryId() {
                return countryId;
            }

            public void setCountryId(String countryId) {
                this.countryId = countryId;
            }

            public Object getCountryName() {
                return countryName;
            }

            public void setCountryName(Object countryName) {
                this.countryName = countryName;
            }

            public Object getCurrentUserId() {
                return currentUserId;
            }

            public void setCurrentUserId(Object currentUserId) {
                this.currentUserId = currentUserId;
            }

            public String getCustomerPhone() {
                return customerPhone;
            }

            public void setCustomerPhone(String customerPhone) {
                this.customerPhone = customerPhone;
            }

            public Object getDeleteFlag() {
                return deleteFlag;
            }

            public void setDeleteFlag(Object deleteFlag) {
                this.deleteFlag = deleteFlag;
            }

            public String getEffectiveAge() {
                return effectiveAge;
            }

            public void setEffectiveAge(String effectiveAge) {
                this.effectiveAge = effectiveAge;
            }

            public Object getEffectiveDate() {
                return effectiveDate;
            }

            public void setEffectiveDate(Object effectiveDate) {
                this.effectiveDate = effectiveDate;
            }

            public int getEndNo() {
                return endNo;
            }

            public void setEndNo(int endNo) {
                this.endNo = endNo;
            }

            public Object getExpirationDate() {
                return expirationDate;
            }

            public void setExpirationDate(Object expirationDate) {
                this.expirationDate = expirationDate;
            }

            public Object getFailureDate() {
                return failureDate;
            }

            public void setFailureDate(Object failureDate) {
                this.failureDate = failureDate;
            }

            public String getInvitationCode() {
                return invitationCode;
            }

            public void setInvitationCode(String invitationCode) {
                this.invitationCode = invitationCode;
            }

            public Object getLastLoggingTime() {
                return lastLoggingTime;
            }

            public void setLastLoggingTime(Object lastLoggingTime) {
                this.lastLoggingTime = lastLoggingTime;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public String getLawer() {
                return lawer;
            }

            public void setLawer(String lawer) {
                this.lawer = lawer;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public String getMail() {
                return mail;
            }

            public void setMail(String mail) {
                this.mail = mail;
            }

            public Object getMonthWorkOrderCount() {
                return monthWorkOrderCount;
            }

            public void setMonthWorkOrderCount(Object monthWorkOrderCount) {
                this.monthWorkOrderCount = monthWorkOrderCount;
            }

            public String getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(String provinceId) {
                this.provinceId = provinceId;
            }

            public Object getProvinceName() {
                return provinceName;
            }

            public void setProvinceName(Object provinceName) {
                this.provinceName = provinceName;
            }

            public String getRegionId() {
                return regionId;
            }

            public void setRegionId(String regionId) {
                this.regionId = regionId;
            }

            public Object getRegionName() {
                return regionName;
            }

            public void setRegionName(Object regionName) {
                this.regionName = regionName;
            }

            public String getRegisterAddr() {
                return registerAddr;
            }

            public void setRegisterAddr(String registerAddr) {
                this.registerAddr = registerAddr;
            }

            public String getRegisterCode() {
                return registerCode;
            }

            public void setRegisterCode(String registerCode) {
                this.registerCode = registerCode;
            }

            public String getRegisterDate() {
                return registerDate;
            }

            public void setRegisterDate(String registerDate) {
                this.registerDate = registerDate;
            }

            public double getRegisterMoney() {
                return registerMoney;
            }

            public void setRegisterMoney(double registerMoney) {
                this.registerMoney = registerMoney;
            }

            public String getRegisterName() {
                return registerName;
            }

            public void setRegisterName(String registerName) {
                this.registerName = registerName;
            }

            public Object getRegisterPhone() {
                return registerPhone;
            }

            public void setRegisterPhone(Object registerPhone) {
                this.registerPhone = registerPhone;
            }

            public int getRowNo() {
                return rowNo;
            }

            public void setRowNo(int rowNo) {
                this.rowNo = rowNo;
            }

            public Object getServerCount() {
                return serverCount;
            }

            public void setServerCount(Object serverCount) {
                this.serverCount = serverCount;
            }

            public Object getSort() {
                return sort;
            }

            public void setSort(Object sort) {
                this.sort = sort;
            }

            public Object getSortKeyword() {
                return sortKeyword;
            }

            public void setSortKeyword(Object sortKeyword) {
                this.sortKeyword = sortKeyword;
            }

            public Object getSubmitCertificationTime() {
                return submitCertificationTime;
            }

            public void setSubmitCertificationTime(Object submitCertificationTime) {
                this.submitCertificationTime = submitCertificationTime;
            }

            public Object getToFrom() {
                return toFrom;
            }

            public void setToFrom(Object toFrom) {
                this.toFrom = toFrom;
            }

            public Object getTrialStatus() {
                return trialStatus;
            }

            public void setTrialStatus(Object trialStatus) {
                this.trialStatus = trialStatus;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Object getUserCount() {
                return userCount;
            }

            public void setUserCount(Object userCount) {
                this.userCount = userCount;
            }

            public Object getValibleEnd() {
                return valibleEnd;
            }

            public void setValibleEnd(Object valibleEnd) {
                this.valibleEnd = valibleEnd;
            }

            public Object getValibleStart() {
                return valibleStart;
            }

            public void setValibleStart(Object valibleStart) {
                this.valibleStart = valibleStart;
            }

            public String getVersionCode() {
                return versionCode;
            }

            public void setVersionCode(String versionCode) {
                this.versionCode = versionCode;
            }

            public Object getVersionName() {
                return versionName;
            }

            public void setVersionName(Object versionName) {
                this.versionName = versionName;
            }
        }

        public static class EmployeeBean {
            /**
             * avatar : null
             * beginNo : 0
             * birthday : 2017-09-04T00:00:00
             * compColor : null
             * companyName : zhucc业主有限公司啊
             * createTime : 2017-11-02T11:06:27
             * creator : null
             * creatorId : null
             * departmentId : 22f3c1a2-d30b-4134-b579-0cec1fa08118
             * departmentName : 创新事业部
             * dicValues : null
             * duty : null
             * email : null
             * employeeCode :
             * employeeId : 3a958f97-8cbb-4190-82ad-0d163cbae491
             * endNo : 0
             * engineerLevel : null
             * engineerStatus : 1
             * failNumber : 0
             * feteDay : null
             * gender : 1
             * genderNum : 0
             * groupName : null
             * importMessages : null
             * isForeign : 1
             * isLastLogin : 0
             * isSyn : null
             * job : null
             * latitude : 30.311546
             * longitude : 120.151315
             * mobilePhone : 15623555415
             * name : wq
             * number : 0
             * officeTelephone : 187728641666
             * ownerCode : 20171026-125311-3
             * positionId : null
             * roleId : 10
             * roleName : null
             * rowNo : 0
             * serviceProviderCode : null
             * sort : null
             * sortKeyword : null
             * state : 1
             * sum : 0
             * synCode : null
             * technicalQualif : null
             * titles : null
             * userGroupId : null
             * userGroupName : null
             * userId : 5b89511a-c1bb-498f-9ce5-27a2105e1216
             * userName : null
             * userPwd : null
             * versionCode : null
             */

            private Object avatar;
            private int beginNo;
            private String birthday;
            private Object compColor;
            private String companyName;
            private String createTime;
            private Object creator;
            private Object creatorId;
            private String departmentId;
            private String departmentName;
            private Object dicValues;
            private Object duty;
            private Object email;
            private String employeeCode;
            private String employeeId;
            private int endNo;
            private Object engineerLevel;
            private String engineerStatus;
            private int failNumber;
            private Object feteDay;
            private String gender;
            private int genderNum;
            private Object groupName;
            private Object importMessages;
            private String isForeign;
            private String isLastLogin;
            private Object isSyn;
            private Object job;
            private String latitude;
            private String longitude;
            private String mobilePhone;
            private String name;
            private int number;
            private String officeTelephone;
            private String ownerCode;
            private Object positionId;
            private String roleId;
            private Object roleName;
            private int rowNo;
            private String serviceProviderCode;
            private Object sort;
            private Object sortKeyword;
            private String state;
            private int sum;
            private Object synCode;
            private Object technicalQualif;
            private Object titles;
            private Object userGroupId;
            private Object userGroupName;
            private String userId;
            private Object userName;
            private Object userPwd;
            private Object versionCode;

            public Object getAvatar() {
                return avatar;
            }

            public void setAvatar(Object avatar) {
                this.avatar = avatar;
            }

            public int getBeginNo() {
                return beginNo;
            }

            public void setBeginNo(int beginNo) {
                this.beginNo = beginNo;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public Object getCompColor() {
                return compColor;
            }

            public void setCompColor(Object compColor) {
                this.compColor = compColor;
            }

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getCreator() {
                return creator;
            }

            public void setCreator(Object creator) {
                this.creator = creator;
            }

            public Object getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(Object creatorId) {
                this.creatorId = creatorId;
            }

            public String getDepartmentId() {
                return departmentId;
            }

            public void setDepartmentId(String departmentId) {
                this.departmentId = departmentId;
            }

            public String getDepartmentName() {
                return departmentName;
            }

            public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
            }

            public Object getDicValues() {
                return dicValues;
            }

            public void setDicValues(Object dicValues) {
                this.dicValues = dicValues;
            }

            public Object getDuty() {
                return duty;
            }

            public void setDuty(Object duty) {
                this.duty = duty;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public String getEmployeeCode() {
                return employeeCode;
            }

            public void setEmployeeCode(String employeeCode) {
                this.employeeCode = employeeCode;
            }

            public String getEmployeeId() {
                return employeeId;
            }

            public void setEmployeeId(String employeeId) {
                this.employeeId = employeeId;
            }

            public int getEndNo() {
                return endNo;
            }

            public void setEndNo(int endNo) {
                this.endNo = endNo;
            }

            public Object getEngineerLevel() {
                return engineerLevel;
            }

            public void setEngineerLevel(Object engineerLevel) {
                this.engineerLevel = engineerLevel;
            }

            public String getEngineerStatus() {
                return engineerStatus;
            }

            public void setEngineerStatus(String engineerStatus) {
                this.engineerStatus = engineerStatus;
            }

            public int getFailNumber() {
                return failNumber;
            }

            public void setFailNumber(int failNumber) {
                this.failNumber = failNumber;
            }

            public Object getFeteDay() {
                return feteDay;
            }

            public void setFeteDay(Object feteDay) {
                this.feteDay = feteDay;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public int getGenderNum() {
                return genderNum;
            }

            public void setGenderNum(int genderNum) {
                this.genderNum = genderNum;
            }

            public Object getGroupName() {
                return groupName;
            }

            public void setGroupName(Object groupName) {
                this.groupName = groupName;
            }

            public Object getImportMessages() {
                return importMessages;
            }

            public void setImportMessages(Object importMessages) {
                this.importMessages = importMessages;
            }

            public String getIsForeign() {
                return isForeign;
            }

            public void setIsForeign(String isForeign) {
                this.isForeign = isForeign;
            }

            public String getIsLastLogin() {
                return isLastLogin;
            }

            public void setIsLastLogin(String isLastLogin) {
                this.isLastLogin = isLastLogin;
            }

            public Object getIsSyn() {
                return isSyn;
            }

            public void setIsSyn(Object isSyn) {
                this.isSyn = isSyn;
            }

            public Object getJob() {
                return job;
            }

            public void setJob(Object job) {
                this.job = job;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getMobilePhone() {
                return mobilePhone;
            }

            public void setMobilePhone(String mobilePhone) {
                this.mobilePhone = mobilePhone;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getOfficeTelephone() {
                return officeTelephone;
            }

            public void setOfficeTelephone(String officeTelephone) {
                this.officeTelephone = officeTelephone;
            }

            public String getOwnerCode() {
                return ownerCode;
            }

            public void setOwnerCode(String ownerCode) {
                this.ownerCode = ownerCode;
            }

            public Object getPositionId() {
                return positionId;
            }

            public void setPositionId(Object positionId) {
                this.positionId = positionId;
            }

            public String getRoleId() {
                return roleId;
            }

            public void setRoleId(String roleId) {
                this.roleId = roleId;
            }

            public Object getRoleName() {
                return roleName;
            }

            public void setRoleName(Object roleName) {
                this.roleName = roleName;
            }

            public int getRowNo() {
                return rowNo;
            }

            public void setRowNo(int rowNo) {
                this.rowNo = rowNo;
            }

            public String getServiceProviderCode() {
                return serviceProviderCode;
            }

            public void setServiceProviderCode(String serviceProviderCode) {
                this.serviceProviderCode = serviceProviderCode;
            }

            public Object getSort() {
                return sort;
            }

            public void setSort(Object sort) {
                this.sort = sort;
            }

            public Object getSortKeyword() {
                return sortKeyword;
            }

            public void setSortKeyword(Object sortKeyword) {
                this.sortKeyword = sortKeyword;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getSum() {
                return sum;
            }

            public void setSum(int sum) {
                this.sum = sum;
            }

            public Object getSynCode() {
                return synCode;
            }

            public void setSynCode(Object synCode) {
                this.synCode = synCode;
            }

            public Object getTechnicalQualif() {
                return technicalQualif;
            }

            public void setTechnicalQualif(Object technicalQualif) {
                this.technicalQualif = technicalQualif;
            }

            public Object getTitles() {
                return titles;
            }

            public void setTitles(Object titles) {
                this.titles = titles;
            }

            public Object getUserGroupId() {
                return userGroupId;
            }

            public void setUserGroupId(Object userGroupId) {
                this.userGroupId = userGroupId;
            }

            public Object getUserGroupName() {
                return userGroupName;
            }

            public void setUserGroupName(Object userGroupName) {
                this.userGroupName = userGroupName;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public Object getUserName() {
                return userName;
            }

            public void setUserName(Object userName) {
                this.userName = userName;
            }

            public Object getUserPwd() {
                return userPwd;
            }

            public void setUserPwd(Object userPwd) {
                this.userPwd = userPwd;
            }

            public Object getVersionCode() {
                return versionCode;
            }

            public void setVersionCode(Object versionCode) {
                this.versionCode = versionCode;
            }
        }
    }
}
