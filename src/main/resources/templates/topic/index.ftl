<!DOCTYPE HTML>
<html>
<head>
    <title>ssm 帖子</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

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
            <div class="header">

                <a href="/?tab=all" class="topic-tab current-tab">全部</a>

                <a href="/?tab=good" class="topic-tab ">精华</a>

                <a href="/?tab=share" class="topic-tab ">分享</a>

                <a href="/?tab=ask" class="topic-tab ">问答</a>

            </div>

            <div class="inner no-padding">
                <div id="topic_list">
                    <div class="cell">

                        <a class="user_avatar pull-left" href="/user/atian25">
                            <img src="https://avatars.githubusercontent.com/u/227713?v=4&amp;s=120" title="atian25">
                        </a>

                        <span class="reply_count pull-left">
    <span class="count_of_replies" title="回复数">
      13
    </span>
    <span class="count_seperator">/</span>
    <span class="count_of_visits" title="点击数">
      46178
    </span>
  </span>


                        <a class="last_time pull-right" href="/topic/62e0d536d3061f33b8e85386#633399aad3061f4d88e87de5">
                            <img class="user_small_avatar" src="https://avatars.githubusercontent.com/u/68574208?v=4&amp;s=120">
                            <span class="last_active_time">8 天前</span>
                        </a>



                        <div class="topic_title_wrapper">


                            <span class="put_top">置顶</span>



                            <a class="topic_title" href="/topic/62e0d536d3061f33b8e85386" title="我的 Node.js 十年 -- 写在 NodeParty 2022 前夕">
                                我的 Node.js 十年 -- 写在 NodeParty 2022 前夕
                            </a>
                        </div>
                    </div>

                    <#list topics as t>

                        <div class="cell">

                            <a class="user_avatar pull-left" href="/">
                                <img src="https://avatars.githubusercontent.com/u/17876392?v=4&amp;s=120" title="cd-xulei">
                            </a>

                            <span class="reply_count pull-left">
    <span class="count_of_replies" title="回复数">
      7
    </span>
    <span class="count_seperator">/</span>
    <span class="count_of_visits" title="点击数">
      1050
    </span>
  </span>


                            <a class="last_time pull-right" href="/topic/63218d3cd3061ff102e871f3#632c6753d3061f7a69e87a7c">
                                <img class="user_small_avatar" src="https://avatars.githubusercontent.com/u/197517?v=4&amp;s=120">
                                <span class="last_active_time">13 天前</span>
                            </a>



                            <div class="topic_title_wrapper">


                                <span class="topiclist-tab">问答</span>

                                <a class="topic_title" href="/topic/detail/${t.id}" title=${t.title}>
                                    ${t.title}
                                </a>
                            </div>
                        </div>


                    </#list>



                    <div class="cell">

                        <a class="user_avatar pull-left" href="/user/hsluoyz">
                            <img src="https://avatars.githubusercontent.com/u/3787410?v=4&amp;s=120" title="hsluoyz">
                        </a>

                        <span class="reply_count pull-left">
    <span class="count_of_replies" title="回复数">
      0
    </span>
    <span class="count_seperator">/</span>
    <span class="count_of_visits" title="点击数">
      1145
    </span>
  </span>



                        <span class="last_time pull-right">
      <span class="last_active_time">1 个月前</span>
    </span>


                        <div class="topic_title_wrapper">


                            <span class="topiclist-tab">分享</span>



                            <a class="topic_title" href="/topic/630ef1cdd3061f680ce869f3" title="Casdoor: 具有 Web UI 界面的开源身份认证、单点登录平台，支持 GitHub、Gitee、QQ、微信、钉钉登录等">
                                Casdoor: 具有 Web UI 界面的开源身份认证、单点登录平台，支持 GitHub、Gitee、QQ、微信、钉钉登录等
                            </a>
                        </div>
                    </div>
                    <div class="cell">

                        <a class="user_avatar pull-left" href="/user/daGaiGuanYu">
                            <img src="https://avatars.githubusercontent.com/u/27003009?v=4&amp;s=120" title="daGaiGuanYu">
                        </a>

                        <span class="reply_count pull-left">
    <span class="count_of_replies" title="回复数">
      2
    </span>
    <span class="count_seperator">/</span>
    <span class="count_of_visits" title="点击数">
      3133
    </span>
  </span>


                        <a class="last_time pull-right" href="/topic/62bc0ec622c334ef51f6f6c7#62f34589d3061f50f6e85c41">
                            <img class="user_small_avatar" src="https://avatars.githubusercontent.com/u/15793313?v=4&amp;s=120">
                            <span class="last_active_time">2 个月前</span>
                        </a>



                        <div class="topic_title_wrapper">


                            <span class="topiclist-tab">分享</span>



                            <a class="topic_title" href="/topic/62bc0ec622c334ef51f6f6c7" title="推荐个插件：PPZ，在 vscode 里操作数据库~">
                                推荐个插件：PPZ，在 vscode 里操作数据库~
                            </a>
                        </div>
                    </div>

                </div>
                <div class="pagination" current_page="1">
                    <ul>


                        <li class="disabled"><a>«</a></li>








                        <li class="disabled active"><a>1</a></li>



                        <li><a href="/?tab=all&amp;page=2">2</a></li>



                        <li><a href="/?tab=all&amp;page=3">3</a></li>



                        <li><a href="/?tab=all&amp;page=4">4</a></li>



                        <li><a href="/?tab=all&amp;page=5">5</a></li>




                        <li><a>...</a></li>



                        <li><a href="/?tab=all&amp;page=8">»</a></li>

                    </ul>
                </div>
                <script>
                    $(document).ready(function () {
                        var $nav = $('.pagination');
                        var current_page = $nav.attr('current_page');
                        if (current_page) {
                            $nav.find('li').each(function () {
                                var $li = $(this);
                                var $a = $li.find('a');
                                if ($a.html() == current_page) {
                                    $li.addClass('active');
                                    $a.removeAttr('href');
                                }
                            });
                        }
                    });
                </script>

            </div>

        </div>
    </div>

</div>


<form action="/topic/add" method="POST">
    <input type="text" name="title" placeholder="请输入 title">
    <br>
    <input type="text" name="content" placeholder="请输入 topic">
    <br>
    <button type="submit">添加</button>
</form>

<div>

    <#list topics as t>
        <h3>
            <a href="/topic/detail/${t.id}">${t.id}: ${t.title}</a>

        </h3>
        <a href="/topic/edit?id=${t.id}">编辑</a>
        <a href="/topic/delete?id=${t.id}&token=${token}">删除</a>
    </#list>
</div>
</body>
</html>