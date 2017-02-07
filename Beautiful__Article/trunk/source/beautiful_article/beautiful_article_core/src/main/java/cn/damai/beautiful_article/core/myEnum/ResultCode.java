package cn.damai.beautiful_article.core.myEnum;

/**
 * Created by Administrator on 2016/11/2 0002.
 */
public enum ResultCode{
    SUCCESS(1,"成功"),
    DEFAULT(2,"失败");
    private int value;
    private String desc;
    ResultCode(int value,String desc){
        this.value = value;
        this.desc = desc;
    }
    public  static ResultCode getEnum(int value){
        ResultCode resultCode = null;
        for(ResultCode rc:values()){
            if(rc.value == value){
                resultCode = rc;
                break;
            }
        }
        return  resultCode;
    }
    public int getValue(){
        return  value;
    }
    public  String getDesc(){
        return  desc;
    }
}
