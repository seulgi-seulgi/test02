package book.ver01;

public class BookMgr {

	private int count = 0;
	private Book[] bookList = new Book[100];

	public BookMgr() {
	}

	public BookMgr(Book[] data) {
		System.arraycopy(data, 0, bookList, count, data.length);
		int i = count;
		count = count + data.length;
	}

	public void addBook(Book data) {
		if (count > bookList.length - 1) {
			Book[] temp = new Book[count + 100];
			System.arraycopy(bookList, 0, temp, 0, count);
			bookList = temp;
		}
		bookList[count] = data;
		count++;
	}

	public void addBook(Book[] data) {
		for (int i = 0; i < data.length; i++) {
			if (count + data.length > bookList.length - 1) {
				Book[] temp = new Book[count + 100];
				System.arraycopy(bookList, 0, temp, 0, count);
				bookList = temp;
			}
			bookList[count] = data[i];
			count++;

		}
	}

	public void deleteBook(String title) {
		Book[] temp = new Book[bookList.length];
		System.arraycopy(bookList, 0, temp, 0, count);
		for (int i = 0; i < count; i++) {
			if (bookList[i].getTitle().equals(title)) {
				this.bookList[i] = null;
				System.arraycopy(temp, i + 1, bookList, i, count);
				this.bookList[count] = null;
				count--;
			}
		}
	}

	public void printBookList() {
		for (int i = 0; i < count; i++) {
			bookList[i].display();
		}
	}

	public void printTitleList() {
		for (int i = 0; i < count; i++) {
			System.out.println(bookList[i].getTitle());
		}
	}

	public void printTotalPrice() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += bookList[i].getPrice();
		}
		System.out.printf("å ������ ���� : %d��", sum);
	}

	// �˻� ��� �߰�
	public void searchBookList(String title) {
		int c = 0;
		for (int i = 0; i < count; i++) {
			if (bookList[i].getTitle().equals(title)) {
				bookList[i].display();
				c++;
			}
		}
		if (c == 0) {
			System.out.println("��û�� ������ �����ϴ�.");
		}
	}

	// ���� ��� �߰�
	public void delete(String title) {
		for (int i = 0; i < count; i++) {
			if (bookList[i].getTitle().equals(title)) {
				System.out.print("�����մϴ� : ");
				bookList[i].display();
				System.arraycopy(bookList, i + 1, bookList, i, count - i);
				count--;
			}
		}
	}
	
	/*// ������Ʈ ��� �߰�
	public void updateTitle(String title, String newTitle) {
		for (int i = 0; i < count; i++) {
			if (bookList[i].getTitle().equals(title)) {
				System.out.print("���� �� : ");
				bookList[i].display();
				System.out.print("���� �� : ");
				bookList[i].setTitle(newTitle);
				bookList[i].display();
			}
		}

	}*/
}
