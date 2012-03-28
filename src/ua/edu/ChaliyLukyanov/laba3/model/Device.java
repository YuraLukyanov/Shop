package ua.edu.ChaliyLukyanov.laba3.model;

public class Device implements java.io.Serializable {

	private int id;
	private int idPrev;
	private int idComponent;
	private String title;

	public Device() {
	
	}
	
	public Device(int id, int idPrev, int idComponent, String title) {
		this.id = id;
		this.idPrev = idPrev;
		this.idComponent = idComponent;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPrev() {
		return idPrev;
	}

	public void setIdPrev(int id_prev) {
		this.idPrev = id_prev;
	}

	public int getIdComponent() {
		return idComponent;
	}

	public void setIdComponent(int id_component) {
		this.idComponent = id_component;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idComponent;
		result = prime * result + idPrev;
		result = prime * result + title.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		Device other = (Device) obj;
		return id == other.id && idComponent == other.idComponent
				&& idPrev == other.idPrev && title.equals(other.title);
	}
}
