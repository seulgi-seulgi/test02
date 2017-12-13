package book.ver01;

public class Book {

	private String title;
	private int price;

	public Book() {

	}

	public Book(String title, int price) {
		setTitle(title);
		setPrice(price);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) { // 유효성 검증
			return;
		}
		this.price = price;
	}

	public void display() {
		System.out.printf("Book[%s : %d 원]%n", title, price);
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

}
