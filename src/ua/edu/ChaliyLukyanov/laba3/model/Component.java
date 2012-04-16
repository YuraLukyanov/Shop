package ua.edu.ChaliyLukyanov.laba3.model;

import java.util.Comparator;

public class Component implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String description;
	private String producer;
	private double weight;
	private String img;
	private double price;

	public Component(int id, String title, String description, String producer,
			double weight, String img, double price) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.producer = producer;
		this.weight = weight;
		this.img = img;
		this.price = price;
	}

	public Component() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null)
			this.title = "";
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img
	 * the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return the decimal
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 * the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((producer == null) ? 0 : producer.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Component))
			return false;
		Component other = (Component) obj;
		return id == other.id && title.equals(other.title)
				&& producer.equals(other.producer)
				&& description.equals(other.description);
	}
	
	public static class PriceComparator implements Comparator<Component>{

		@Override
		public int compare(Component o1, Component o2) {
			double id1 = o1.getPrice();
			double id2 = o2.getPrice();
			if (id1 > id2)
				return 1;
			else if (id1 < id2)
				return -1;
			else
				return 0;
		}
	}
	
	public static class ProducerComparator implements Comparator<Component>{
		
		@Override
		public int compare(Component o1, Component o2) {
			String pr1 = o1.getProducer();
			String pr2 = o2.getProducer();
			return pr1.compareTo(pr2);
		}
	}
	
	public static class TitleComparator implements Comparator<Component>{

		@Override
		public int compare(Component o1, Component o2) {
			String pr1 = o1.getTitle();
			String pr2 = o2.getTitle();
			return pr1.compareTo(pr2);
		}
	}
}



