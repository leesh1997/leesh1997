
public class WebtoonInfo {
	// ����
	private String title;
	// �۰�
	private String writer;
	// ������
	private String openDay;

	
	
	
	@Override
	public String toString() {
		return "WebtoonInfo [title=" + title + ", writer=" + writer + ", openDay=" + openDay + "]";
	}

	public WebtoonInfo(String title, String writer, String openDay) {
		super();
		this.title = title;
		this.writer = writer;
		this.openDay = openDay;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getOpenDay() {
		return openDay;
	}

	public void setOpenDay(String openDay) {
		this.openDay = openDay;
	}

}
