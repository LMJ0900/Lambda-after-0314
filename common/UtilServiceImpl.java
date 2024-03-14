package com.turing.api.common;

public class UtilServiceImpl implements UtilService  {

    private static UtilService instance = new UtilServiceImpl();
    private UtilServiceImpl(){}

    public static UtilService getInstance(){
        return  instance;
    }
    @Override
    public int createRandomInteger(int start, int gapBetweenStartAndEnd) {
        //0 이상 50 미만의 값을 생성하고 150을 더해줌으로써 키의 범위를 150이상 200 미만으로 만듬
        return start + (int)(Math.random() * gapBetweenStartAndEnd);
    }

    @Override
    public double createRandomDouble(int start, int gapBetweenStartAndEnd) {
        return Math.round(start + (Math.random()* gapBetweenStartAndEnd) * 10) / 10.0;
    }


    public String createRandomMemberName(){
        String memberName = "";
        for(; memberName.length() < 5;
            memberName += String.valueOf((char)('a' + this.createRandomInteger(0,26))));     //i++자리에 바로 할당, a 아스키코드는 97이므로 97+26 = z이다.

        return memberName;
    }

    @Override
    public char createRandomInt(int i, int i1) {
        return 0;
    }

    public String createRandomName() {
        String[] name = {"이정재", "마동석", "송강호", "윤여정", "황정민", "정우성", "이병헌", "현 빈", "유해진", "손석구",
                "전도연", "손예진", "하지원", "김하늘", "송중기", "하정우", "장동건", "원 빈", "박해일", "소지섭", "김혜수"};
        return name[createRandomInteger(0, 20)];
    }

    public  String createRandomTitle() {
        String[] titles = {"혼인과 가족생활","근로조건의 기준","모든 국민은","위원은 정당에 가입",
                "국무총리 또는 행정각부", "감사원은 원장을 포함한 5인", "국회의 회의는 공개한다.", "법률이 정하는 주요방위산업체",
                "국무회의는 정부의 권한"};
        return null;
    }

    public String createRandomContent() {
        String[] content = {"대법관의 임기는 6년으로 하며, 법률이 정하는 바에 의하여 연임할 수 있다.",
                "근로조건의 기준은 인간의 존엄성을 보장하도록 법률로 정한다.", "대통령은 법률이 정하는 바에 의하여 사면·감형 또는 복권을 명할 수 있다.",
                "모든 국민은 그 보호하는 자녀에게 적어도 초등교육과 법률이 정하는 교육을 받게 할 의무를 진다.",
                "위원은 정당에 가입하거나 정치에 관여할 수 없다. 헌법재판소 재판관은 정당에 가입하거나 정치에 관여할 수 없다.",
                "국무총리 또는 행정각부의 장은 소관사무에 관하여 법률이나 대통령령의 위임 또는 직권으로 총리령 또는 부령을 발할 수 있다.",
                "감사원은 원장을 포함한 5인 이상 11인 이하의 감사위원으로 구성한다.",
                "국회의 회의는 공개한다. 다만, 출석의원 과반수의 찬성이 있거나 의장이 국가의 안전보장을 위하여 필요하다고 인정할 때에는 공개하지 아니할 수 있다.",
                "법률이 정하는 주요방위산업체에 종사하는 근로자의 단체행동권은 법률이 정하는 바에 의하여 이를 제한하거나 인정하지 아니할 수 있다.",
                "국무회의는 정부의 권한에 속하는 중요한 정책을 심의한다. 국민의 자유와 권리는 헌법에 열거되지 아니한 이유로 경시되지 아니한다."};
        return content[createRandomInteger(0,10)];
    }

    @Override
    public String createRandomPno() {
        return null;
    }



    public String createRandomCompany(){
        String[] companies = {"구글","엔비디아","메타","삼성","LG","애플"};
        return companies[createRandomInteger(0,5)];
    }


}