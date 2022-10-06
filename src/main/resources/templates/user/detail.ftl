<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${user.username}</title>

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
                    Hey,${user.username}
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
            <div class="header">
                <p>homepage</p>
            </div>

            <div class="inner no-padding">
                <div id="topic_list">
                    <div class="cell">

                        <a class="user_avatar pull-left" href="/">
                            <img src="https://avatars.githubusercontent.com/u/17876392?v=4&amp;s=120" title="cd-xulei">
                        </a>

                        <span class="reply_count pull-left"></span>


                        <a class="last_time pull-right" href="/topic/63218d3cd3061ff102e871f3#632c6753d3061f7a69e87a7c">
                            <img class="user_small_avatar" src="https://avatars.githubusercontent.com/u/197517?v=4&amp;s=120">
                        </a>



                        <div class="topic_title_wrapper">
                            <p>${user.username}</p>
                        </div>
                    </div>

                </div>



            </div>

        </div>
        <div class="panel">
            <div class="header">
                <p>create</p>
            </div>

            <div class="inner no-padding">
                <div id="topic_list">


                    <#list Topics as t>

                        <div class="cell">

                            <a class="user_avatar pull-left" href="/">
                                <img src="https://avatars.githubusercontent.com/u/17876392?v=4&amp;s=120" title="cd-xulei">
                            </a>

                            <span class="reply_count pull-left"></span>


                            <a class="last_time pull-right" href="/topic/63218d3cd3061ff102e871f3#632c6753d3061f7a69e87a7c">
                                <img class="user_small_avatar" src="https://avatars.githubusercontent.com/u/197517?v=4&amp;s=120">
                                <span class="last_active_time">${t.updatedTime}</span>
                            </a>



                            <div class="topic_title_wrapper">



                                <a class="topic_title" href="/topic/detail/${t.id}" title=${t.title}>
                                    ${t.title}
                                </a>
                            </div>
                        </div>


                    </#list>

                </div>



            </div>

        </div>
    </div>
</div>

</body>
</html>