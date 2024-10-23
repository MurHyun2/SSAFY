<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<form action="search" method="GET" class="row lh-base">
	<input type="hidden" name="lastPage" value="${pr.lastPage}">
	<input type="hidden" name="listSize" value="${pr.listSize}">
	<div class="col-2">
		<label class="form-label">검색기준</label> 
		<select class="form-select" name="key">
			<option value="none" <c:if test="${search.key == 'none'}">selected="selected"</c:if>>없음</option>
			<option value="writer" <c:if test="${search.key == 'writer'}">selected="selected"</c:if>>쓰니</option>
			<option value="title" <c:if test="${search.key == 'title'}">selected="selected"</c:if>>제목</option>
			<option value="content" <c:if test="${search.key == 'content'}">selected="selected"</c:if>>내용</option>
		</select>
	</div>
	<div class="col-5">
		<label class="form-label">검색 내용</label> 
		<input type="text" name="word" class="form-control" value="${search.word}">
	</div>
	<div class="col-2">
		<label class="form-label">정렬기준</label> 
		<select class="form-select" name="orderBy">
			<option value="none" <c:if test="${search.orderBy == 'none'}">selected="selected"</c:if>>없음</option>
			<option value="writer" <c:if test="${search.orderBy == 'writer'}">selected="selected"</c:if>>쓰니</option>
			<option value="title" <c:if test="${search.orderBy == 'title'}">selected="selected"</c:if>>제목</option>
			<option value="view_cnt" <c:if test="${search.orderBy == 'view_cnt'}">selected="selected"</c:if>>조회수</option>
		</select>
	</div>
	<div class="col-2">
		<label class="form-label">정렬방향</label> 
		<select class="form-select" name="orderByDir">
			<option value="asc" <c:if test="${search.orderByDir == 'asc'}">selected="selected"</c:if>>오름차순</option>
			<option value="desc" <c:if test="${search.orderByDir == 'desc'}">selected="selected"</c:if>>내림차순</option>
		</select>
	</div>
	<div class="col-1 d-flex align-items-end">
		<input type="submit" value="검색" class="btn btn-primary">
	</div>
</form>