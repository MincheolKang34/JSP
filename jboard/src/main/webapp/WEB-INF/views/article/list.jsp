<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="./_header.jsp" %>
<main id="article">
    <section class="list">
        <nav>
            <h1>
                전체 글목록
                <span>1012건</span>
            </h1>
            <form action="./searchList.html">
                <select name="searchType">
            		<option value="title">제목</option>
            		<option value="content">내용</option>
            		<option value="writer">글쓴이</option>
            	</select>
                <input type="text" name="keyword" placeholder="검색 키워드 입력">
                <input type="submit" value="검색">
            </form>
        </nav>
                        
        <table border="0">                    
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>날짜</th>
                <th>조회</th>
            </tr>                    
            <c:forEach var="article" items="${ dtoList }">
            <tr>
                <td>${ article.ano }</td>
                <td><a href="/jboard/article/view.do">${ article.title }[${ article.comment_cnt }]</a></td>
                <td>${ article.nick }</td>
                <td>${ article.wdate }</td>
                <td>${ article.hit_cnt }</td>
            </tr>
            </c:forEach>
        </table>

        <div class="page">
            <a href="#" class="prev">이전</a>
            <c:forEach var="num" begin="${ pageGroupStart }" end="${ pageGroupEnd }">
            	<a href="/jboard/article/list.do?pg=${ num }" class="num">${ num }</a>
            </c:forEach>
            <a href="#" class="next">다음</a>
        </div>

        <a href="/jboard/article/write.do" class="btn btnWrite">글쓰기</a>
        
    </section>
</main>
<%@ include file="./_footer.jsp" %>