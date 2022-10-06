<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>搭建博客</title>

    <link rel="stylesheet" href="/1.css">
    <link rel="stylesheet" href="/2.css">
</head>
<body>

<div>
    <div class="container mx-auto prose py-12 sm:py-24 px-12 sm:px-0">
        <div class="mb-12">
            <a class="no-underline font-bold" href="/">Riniith's Blog</a>
        </div>
        <h1>搭建博客</h1>
        <div class="italic text-gray-500">
            2022/9/24
        </div>
        <div>
            <p>第一次搭建博客有考虑过很多种方式，试过hexo和hugo，由于我希望博客有更多功能(如收发邮件)而网页本身也更偏好于简介明了，不需要很多华丽的主题，加之github国内访问很慢很不稳定，所以还是把博客放在了自己的站点而非Github Pages。</p>
            <p>说是"自己的站点"，其实搭建网站也是第一次，首先，让我阐述一下用到的工具和框架。</p>
            <ul>
                <li>此网站选用Spring Boot 自动配置，Spring MVC作为框架，Tomcat作为Servlet容器，数据储存使用MySQ，ORM使用MyBatis。</li>
                <li>项目部署使用Nginx作为反向代理，处理静态资源缓存压缩</li>
                <li>对于变动频率较低的数据进行基于Redis的缓存优化</li>
            </ul>
            <br>
            <p>之前从来没有过使用博客的想法，是因为独立博客很难做到高阅读量，而我也实在是一个对他人表达欲很低的人，学习经验或是生活感悟我更偏向于放在手机备忘录。</p>
            <p>这次开始写博客的一个目的是让陌生人通过博客了解到我是什么人、我在想什么、我做了什么。特别是这段时期我改变了我的就业方向，我希望在我在找工作的时候，一个精彩的博客比起一份的CV，更能让HR 了解我对技术的属于自己的思考、我在业余时间在想的事情是什么。</p>
            <p>由于本人对自己的耐心有清晰的认知，所以此博客很可能做不到经常更新，对于博客的更新频率或者博客本身的长短没有期待。独立博客有免于献媚的自由，有排版自由，有修改删除自己说了算的自由。</p>
            <p>希望此博客会即使不再更新也依然有阅读的价值，依然有意义。</p>

        </div>
        <hr>
        <footer class="text-sm py-12 text-gray-500 text-center">
            Riniith's Blog since 2022
        </footer>
    </div>

</div>



</body>