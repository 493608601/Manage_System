package entity;

public class Journal implements Cloneable {
	private String id;
	private String zbld;//值班领导
	private String zbmj;//值班民警
	private String zbfj;//值班辅警
	private long kssj;//开始时间
	private long jssj;//结束时间
	private long fssj;//发生时间
	private String content;//发生事件内容
	private String sxt;//摄像头ID
	private String bxqk;//保修情况
	private String bz;//备注
	private String type;//类型
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZbld() {
		return zbld;
	}
	public void setZbld(String zbld) {
		this.zbld = zbld;
	}
	public String getZbmj() {
		return zbmj;
	}
	public void setZbmj(String zbmj) {
		this.zbmj = zbmj;
	}
	public String getZbfj() {
		return zbfj;
	}
	public void setZbfj(String zbfj) {
		this.zbfj = zbfj;
	}
	public long getKssj() {
		return kssj;
	}
	public void setKssj(long kssj) {
		this.kssj = kssj;
	}
	public long getJssj() {
		return jssj;
	}
	public void setJssj(long jssj) {
		this.jssj = jssj;
	}
	public String getBxqk() {
		return bxqk;
	}
	public void setBxqk(String bxqk) {
		this.bxqk = bxqk;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getFssj() {
		return fssj;
	}
	public void setFssj(long fssj) {
		this.fssj = fssj;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSxt() {
		return sxt;
	}
	public void setSxt(String sxt) {
		this.sxt = sxt;
	}
	
    @Override  
    public Journal clone() {  
    	Journal journal = null;  
        try {  
        	journal = (Journal) super.clone();  
        } catch (CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return journal;  
    }  
	
}
