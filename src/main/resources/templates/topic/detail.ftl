<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${topic.title}</title>

    <link rel="stylesheet" href="/index.css">
    <link rel="stylesheet" href="/1.css">
    <link rel="stylesheet" href="/2.css">
    <link rel="stylesheet" href="/3.css">
</head>
<body>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="/" ></a>
            <form id="search_form" class="navbar-search" action="/search">
                <input type="text" id="q" name="q" class="search-query span3" value="">
            </form>
            <ul class="nav pull-right">
                <li><a href="/topic">首页</a></li>
                <li><a href="/login">登录</a></li>
                <li><a href="/">主页</a></li>
                <li><a href="/register">注册</a></li>
                <li><a href="/todo">TODO</a></li>
                <li><a href="/about" target="">关于</a></li>

            </ul>
            <a class="btn btn-navbar" id="responsive-sidebar-trigger">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
        </div>
    </div>
</div>

<div id="main">
    <div id="sidebar">
        <div class="panel">

            <div class="inner">
                <img src='/1.jpeg'>

                <div>
                    Hey,
                    <a href="/"></a>
                    <br>
                    <br>
                    <span class="span-info">
            for topic
          </span>
                    </a>
                </div>
            </div>

        </div>
    </div>


    <div id="content">
        <div class="panel">
            <div class="header topic_header">
      <span class="topic_full_title">




        ${topic.title}
      </span>
                <div class="changes">
        <span>
                  <a href="/topic/edit?id=${topic.id}">编辑</a>
        <a href="/topic/delete?id=${topic.id}&token=${token}">删除</a>
        </span>

        <span>
        ${topic.createdTime}
        ${topic.updatedTime}
        </span>
        <span>
          作者 <a href="/user/detail/${user.id}">${user.username}</a>
        </span>




                </div>

            </div>
            <div class="inner topic">

                <div class="topic_content">
                    <div class="markdown-text">
                        <p>${topic.content}</p>
                    </div>
            </div>
        </div>

        <div class="panel">
            <div class="header">
                <span class="col_fade">回复</span>
            </div>
            <div class="inner topic">
                <div class="topic_content markdown-text">
                <form action="/topic/addComment" method="POST">
                    <input type="number"  name="topicId" value="${topic.id}">
                    <input type="text" name="content" placeholder="请输入 comment">
                    <br>
                    <button type="submit">添加</button>
                </form>
                </div>
            </div>
            <#list topic.commentList as c>
            <div class="cell reply_area reply_item
  " reply_id="63310e55d3061f5aa1e87c94" reply_to_id="" id="63310e55d3061f5aa1e87c94">
                <div class="author_content">
                    <a href="/user/i5ting" class="user_avatar">
                        <img src="https://avatars.githubusercontent.com/u/3118295?v=4&amp;s=120" title="i5ting"></a>

                    <div class="user_info">
                        <a class="dark reply_author" href="/user/i5ting">${c.user.username}</a>
                        <span>${c.createdTime}</span>

                    </div>
                    <div class="user_action">
      <span>
        <i class="fa up_btn
          fa-thumbs-o-up
          invisible" title="喜欢"></i>
        <span class="up-count">
        </span>
      </span><span></span>
                    </div>
                </div>
                <div class="reply_content from-i5ting">
                    <div class="markdown-text"><p>${c.content}</p>
                    </div>
                </div>
                <div class="clearfix">
                    <div class="reply2_area">

                    </div>
                </div>
            </div>

            </#list>
        </div>



    </div>

</div>

<h1>${topic.title}</h1>

<p>
    ${topic.content}
</p>

<#list topic.commentList as c>
    <div>
        ${c.id}: ${c.user.username}  ${c.content}
    </div>
</#list>

</body>
</html>