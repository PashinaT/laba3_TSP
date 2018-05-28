package pack;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "task")

public class Task  {
    @XmlElement(name="argument1")
    private String a="";
    @XmlElement(name="argument2")
    private String b="";
    private int result=0;

    public Task(String a,String b)
    {
        this.a=a;
        this.b=b;
    }

    public Task(){}

    public int getResult(){
        return result;
    }



    public String getA() {
        return a;
    }



    public String getB() {
        return b;
    }

    public void setResult(int result) {
        this.result = result;
    }

}
