package world.asia;

public class Korea {

	private int population;			// �α�
	
	String capital;					// ����
	
	private String[] special = {
			"���ֽ�ũ", "�뱸���", "õ��ȣ������" };
	
	public String name;
	
	protected String president;
	
	public void setPopulation(int population) {
		if (population > 0) {
			this.population = population;
		}
	}
	
	void doSomething() {
		population += 100000;
		capital = "����";
		special[0] = "�ѻ���";
		name = "���ѹα�";
		president = "�ڱ���";
	}
	
}














