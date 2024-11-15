package com.ssafy.hw.day05.step4;

/**
 * 상품 객체를 생성하고 출력하는 클래스
 *
 */
public class ProductTest {
	public static void main(String[] args) {
		Product pd1 = new Product("1", "과자", 1500, 100, "농심", "1");
		Product pd2 = new Product("2", "빵", 2500, 50, "삼립", "2");

		ProductManager pm = new ProductManager();

		pm.addProduct(pd1);
		pm.addProduct(pd2);

		System.out.println("-------------getList-------------");
		Product[] productList = pm.getProductList();
		for (Product p : productList)
			System.out.println(p);

		Product pd3 = new Product("2", "맘모스빵", 3500, 10, "삼립", "2");
		pm.updateProduct(pd3);
		System.out.println("-------------updateProduct-------------");
		productList = pm.getProductList();
		for (Product p : productList)
			System.out.println(p);

		pm.removeProduct("2");
		System.out.println("-------------removeProduct-------------");
		productList = pm.getProductList();
		for (Product p : productList)
			System.out.println(p);
		
		pm.sell("1", 10);
		System.out.println("-------------sell-------------");
		productList = pm.getProductList();
		for (Product p : productList)
			System.out.println(p);
		
		Review rv1 = new Review(1, "1", "김싸피", "정말 싸고 맛있어요!");
		Review rv2 = new Review(2, "1", "이싸피", "싸긴한데 맛은 없네요 ㅡㅡ");
		
		pm.addReview(rv1);
		pm.addReview(rv2);
		System.out.println("-------------addReview-------------");
		Review[] reviews = pm.getProductReview("1");
		for (Review r : reviews) {
			System.out.println(r);
		}
		
		pm.removeReview(2);
		System.out.println("-------------removeReview-------------");
		reviews = pm.getProductReview("1");
		for (Review r : reviews) {
			System.out.println(r);
		}
		
	}
}
