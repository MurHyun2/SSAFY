package com.ssafy.hw.day05.step4;

import java.util.Arrays;

/**
 * 상품리스트를 배열로 유지하며 관리하는 클래스
 */
public class ProductManager {
	// 코드를 작성하세요.
	private int MAX_PRODUCT_SIZE = 100;
	private int MAX_REVIEW_SIZE = 1000;
	private Product[] products = new Product[MAX_PRODUCT_SIZE];
	private Review[] reviews = new Review[MAX_REVIEW_SIZE];
	int pCount = 0;
	int rCount = 0;

	boolean addProduct(Product product) {
		if (pCount < MAX_PRODUCT_SIZE) {
			products[pCount++] = product;
			return true;
		}
		return false;
	}

	boolean updateProduct(Product product) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode().equals(product.getpCode())) {
				products[i] = product;
				return true;
			}
		}
		return false;
	}
	
	boolean removeProduct(String pCode) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode().equals(pCode)) {
				products[i] = null;
				pCount--;
				return true;
			}
		}
		return false;
	}
	
	int sell(String pCode, int cnt) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode().equals(pCode)) {
				products[i].setQuantity(products[i].getQuantity() - cnt);
				return products[i].getQuantity() - cnt;
			}
		}
		return 0;
	}
	
	Product[] getProductList() {
		return Arrays.copyOf(products, pCount);
	}
	
	Product searchByCode(String pCode) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode().equals(pCode)) {
				return products[i];
			}
		}
		return new Product();
	}
	
	boolean addReview(Review review) {
		if(rCount < MAX_REVIEW_SIZE) {
			reviews[rCount++] = review;
			return true;
		}
		return false;
	}
	
	boolean removeReview(int reviewId) {
		for (int i = 0; i < rCount; i++) {
			if(reviews[i].getReviewId() == reviewId) {
				reviews[i] = null;
				rCount--;
				return true;
			}
		}
		return false;
	}
	
	Review[] getProductReview(String pCode) {
		Review[] rv = new Review[rCount];
		for (int i = 0; i < rCount; i++) {
			if(reviews[i].getpCode().equals(pCode) && reviews[i] != null) {
				rv[i] = reviews[i];
			}
		}
		return rv;
	}
}
