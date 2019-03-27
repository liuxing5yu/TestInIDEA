/**
 * 
 */

/**
 * 
 *
 * @author hwj
 * @date 2019年3月25日 下午2:46:51 
 *
 */
public class QueueUnit {

	// 医院名称
	private String hostpital;
	// 科室名称
	private String dept;
	// 医生名称
	private String doctor;
	// 排名，即第几位
	private int rank;

	public String getHostpital() {
		return hostpital;
	}

	public void setHostpital(String hostpital) {
		this.hostpital = hostpital;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "QueueUnit{" + "hostpital='" + hostpital + '\'' + ", dept='" + dept + '\'' + ", doctor='" + doctor + '\'' + ", rank=" + rank + '}';
	}
}
