<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-03
  Time: 오후 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width,initial-scale = 1.0"/>
<html>
<head>
    <title>Main & List</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="style.css"/>

    <script>

    </script>
</head>
<body>

<!-- Login , Query , other Nav -->
<header class="headerTest">
    <nav>
        <div class="row" style="border: 1px solid black;">
            <!-- Query , Main Logo -->
            <div class="col-sm-7">
            </div>
            <!-- Login -->
            <div class="col-sm-5" id="main_auth">
                <div id="status" class="loginForm">
                    <div class="row">
                        <div class="col-sm-3">
                            <label for="id">아이디</label>
                        </div>
                        <div class="col-sm-7">
                            <input id="id" name="id" type="text" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-3">
                            <label for="passwd">비밀번호 </label>
                        </div>
                        <div class="col-sm-7">
                            <input id="passwd" name="passwd" type="password" required>
                        </div>
                    </div>
                    <div class="buttonDiv">
                        <button class="btn btn-primary" id="loginBtn">로그인</button>
                        <button class="btn btn-primary" id="signBtn">회원가입</button>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>

<article>
    <div class="container" style="margin:15px">
        <%--글쓰기버튼--%>
        <div class="huge-top">
            <button class="btn btn-normal" id="insert" style="margin-left: 20px"
                    onclick="window.location='writeForm.do'">글쓰기</button>
        </div>
        <table class="table table-board" style="margin: 15px;text-align: center">
            <colgroup>
                <col width="7%"><!--글번호 -->
                <col width="*"><!--제목 -->
                <col width="7%"><!--작성자 -->
                <col width="25%"><!--작성일 -->
                <col width="7%"><!--조회수 -->
            </colgroup>
            <thead>
            <th style="text-align: center">글 번호</th>
            <th style="text-align: center">제목</th>
            <th style="text-align: center">작성자</th>
            <th style="text-align: center">작성일</th>
            <th style="text-align: center">조회수</th>
            </thead>

            <c:if test="${count == 0}">
        </table>
        <div class="alert alert-success text-center">
            <strong>게시판에 저장된 글이 없습니다 ㅠ,ㅠ</strong>
        </div>
        </c:if>

        <c:if test="${count != 0}">
            <c:forEach var="vo" items="${boardList}">
                <tr>
                        <%--표시되는 글번호--%>
                    <td>${number}
                        <c:set var="number" value="${number-1}"/>
                    </td>
                        <%--제목--%>
                    <td style="text-align: left">
                        <a href="content.do?num=${vo.num}&pageNum=${bp.cur_Page}">&nbsp;&nbsp;&nbsp;${vo.subject}</a>
                    </td>
                        <%--조회수 많을때 뜨는 아이콘 --%>
                    <c:if test="${vo.readcount > 10}">
                        <img src="hotArticle.gif" border="0" height="16"/>
                    </c:if>

                        <%-- 작성자,이메일  --%>
                    <td>
                        <a href="malito:${vo.email}">${vo.writer}</a>
                    </td>

                    <td>
                            ${vo.regdate}
                    </td>

                    <td>
                            ${vo.readcount}
                    </td>

                </tr>
            </c:forEach>
        </c:if>
        </table>


        <%-- 페이지 이동 처리 --%>

        <div class="row">
            <div class="col-8">
                <div class="pagePro" style="text-align: center; margin: auto; display: table;">
                    <%-- pagination 사용 --%>
                    <ul class="pagination">

                        <%--이전버튼 --%>
                        <c:if test="${bp.isPre()}">
                            <li class="page-item">
                                <button class="page-link">
                                    <a href="list.do?pageNum=${bp.getPage_Start()-bp.p_size}">
                                        Previous
                                    </a>
                                </button>
                            </li>
                        </c:if>

                        <%--페이징처리 todo 페이징 앞뒤 로케이션확인--%>

                        <c:forEach var="counter" begin="${bp.getPage_start()}" end="${bp.getPage_end()}">
                            <c:if test="${search_text ne ''}">
                                <li class="page-item">
                                    <button class="page-link">
                                        <a href="javascript:window.location='list.do?pageNum=${counter}&search_type=${search_type}&search_text=${search_text}'">
                                                ${counter}
                                        </a>
                                    </button>
                                </li>
                            </c:if>

                            <c:if test="${search_text eq ''}">
                                <li class="page-item">
                                    <button class="page-link">
                                        <a href="javascript:window.location='list.do?pageNum=${counter}">
                                                ${counter}
                                        </a>
                                    </button>
                                </li>
                            </c:if>
                        </c:forEach>


                        <%--다음버튼 --%>
                        <c:if test="${bp.isNext()}">
                            <li class="page-item">
                                <button class="page-link">
                                    <a href="list.do?pageNum=${bp.getPage_Start()+bp.p_size}">
                                        Next
                                    </a>
                                </button>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>

            <div class="col-4">
                <%--검색창--%>
                <form id="togglingForm" method="get" class="form-horizontal" name="listForm" action="list.do">
                    <input type="hidden" name="pageNum" value="${pageNum}" />
                    <div class="form-group">
                        <div class="col-xs-9">

                            <label class="radio-inline"> 검색옵션 </label>  
                            <label class="radio-inline">
                                <input type="radio" name="search_type" value="subject" checked="checked"/> 제목
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="search_type" value="content"/> 내용
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="search_type" value="writer"/> 작성자
                            </label>
                            <input type="text" class="form-control" name="search_text" value=""
                                   required/>
                        </div>

                        <div class="col-xs-2">
                            <button type="submit" class="btn btn-primary" data-toggle="" style="margin-top: 1.5%;">Search</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</article>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>
