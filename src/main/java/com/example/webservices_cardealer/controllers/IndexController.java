package com.example.webservices_cardealer.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@Controller
public class IndexController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcomeAsHTML() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<!--[if IE]><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><![endif]-->\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<meta name=\"generator\" content=\"Asciidoctor 1.5.8\">\n" +
                "<meta name=\"author\" content=\"Benjamin Boson, Oscar Johanneson\">\n" +
                "<title>WebService CarDealer</title>\n" +
                "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic%7CNoto+Serif:400,400italic,700,700italic%7CDroid+Sans+Mono:400,700\">\n" +
                "<style>\n" +
                "/* Asciidoctor default stylesheet | MIT License | http://asciidoctor.org */\n" +
                "/* Uncomment @import statement below to use as custom stylesheet */\n" +
                "/*@import \"https://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic%7CNoto+Serif:400,400italic,700,700italic%7CDroid+Sans+Mono:400,700\";*/\n" +
                "article,aside,details,figcaption,figure,footer,header,hgroup,main,nav,section,summary{display:block}\n" +
                "audio,canvas,video{display:inline-block}\n" +
                "audio:not([controls]){display:none;height:0}\n" +
                "script{display:none!important}\n" +
                "html{font-family:sans-serif;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}\n" +
                "a{background:transparent}\n" +
                "a:focus{outline:thin dotted}\n" +
                "a:active,a:hover{outline:0}\n" +
                "h1{font-size:2em;margin:.67em 0}\n" +
                "abbr[title]{border-bottom:1px dotted}\n" +
                "b,strong{font-weight:bold}\n" +
                "dfn{font-style:italic}\n" +
                "hr{-moz-box-sizing:content-box;box-sizing:content-box;height:0}\n" +
                "mark{background:#ff0;color:#000}\n" +
                "code,kbd,pre,samp{font-family:monospace;font-size:1em}\n" +
                "pre{white-space:pre-wrap}\n" +
                "q{quotes:\"\\201C\" \"\\201D\" \"\\2018\" \"\\2019\"}\n" +
                "small{font-size:80%}\n" +
                "sub,sup{font-size:75%;line-height:0;position:relative;vertical-align:baseline}\n" +
                "sup{top:-.5em}\n" +
                "sub{bottom:-.25em}\n" +
                "img{border:0}\n" +
                "svg:not(:root){overflow:hidden}\n" +
                "figure{margin:0}\n" +
                "fieldset{border:1px solid silver;margin:0 2px;padding:.35em .625em .75em}\n" +
                "legend{border:0;padding:0}\n" +
                "button,input,select,textarea{font-family:inherit;font-size:100%;margin:0}\n" +
                "button,input{line-height:normal}\n" +
                "button,select{text-transform:none}\n" +
                "button,html input[type=\"button\"],input[type=\"reset\"],input[type=\"submit\"]{-webkit-appearance:button;cursor:pointer}\n" +
                "button[disabled],html input[disabled]{cursor:default}\n" +
                "input[type=\"checkbox\"],input[type=\"radio\"]{box-sizing:border-box;padding:0}\n" +
                "button::-moz-focus-inner,input::-moz-focus-inner{border:0;padding:0}\n" +
                "textarea{overflow:auto;vertical-align:top}\n" +
                "table{border-collapse:collapse;border-spacing:0}\n" +
                "*,*::before,*::after{-moz-box-sizing:border-box;-webkit-box-sizing:border-box;box-sizing:border-box}\n" +
                "html,body{font-size:100%}\n" +
                "body{background:#fff;color:rgba(0,0,0,.8);padding:0;margin:0;font-family:\"Noto Serif\",\"DejaVu Serif\",serif;font-weight:400;font-style:normal;line-height:1;position:relative;cursor:auto;tab-size:4;-moz-osx-font-smoothing:grayscale;-webkit-font-smoothing:antialiased}\n" +
                "a:hover{cursor:pointer}\n" +
                "img,object,embed{max-width:100%;height:auto}\n" +
                "object,embed{height:100%}\n" +
                "img{-ms-interpolation-mode:bicubic}\n" +
                ".left{float:left!important}\n" +
                ".right{float:right!important}\n" +
                ".text-left{text-align:left!important}\n" +
                ".text-right{text-align:right!important}\n" +
                ".text-center{text-align:center!important}\n" +
                ".text-justify{text-align:justify!important}\n" +
                ".hide{display:none}\n" +
                "img,object,svg{display:inline-block;vertical-align:middle}\n" +
                "textarea{height:auto;min-height:50px}\n" +
                "select{width:100%}\n" +
                ".center{margin-left:auto;margin-right:auto}\n" +
                ".stretch{width:100%}\n" +
                ".subheader,.admonitionblock td.content>.title,.audioblock>.title,.exampleblock>.title,.imageblock>.title,.listingblock>.title,.literalblock>.title,.stemblock>.title,.openblock>.title,.paragraph>.title,.quoteblock>.title,table.tableblock>.title,.verseblock>.title,.videoblock>.title,.dlist>.title,.olist>.title,.ulist>.title,.qlist>.title,.hdlist>.title{line-height:1.45;color:#7a2518;font-weight:400;margin-top:0;margin-bottom:.25em}\n" +
                "div,dl,dt,dd,ul,ol,li,h1,h2,h3,#toctitle,.sidebarblock>.content>.title,h4,h5,h6,pre,form,p,blockquote,th,td{margin:0;padding:0;direction:ltr}\n" +
                "a{color:#2156a5;text-decoration:underline;line-height:inherit}\n" +
                "a:hover,a:focus{color:#1d4b8f}\n" +
                "a img{border:none}\n" +
                "p{font-family:inherit;font-weight:400;font-size:1em;line-height:1.6;margin-bottom:1.25em;text-rendering:optimizeLegibility}\n" +
                "p aside{font-size:.875em;line-height:1.35;font-style:italic}\n" +
                "h1,h2,h3,#toctitle,.sidebarblock>.content>.title,h4,h5,h6{font-family:\"Open Sans\",\"DejaVu Sans\",sans-serif;font-weight:300;font-style:normal;color:#ba3925;text-rendering:optimizeLegibility;margin-top:1em;margin-bottom:.5em;line-height:1.0125em}\n" +
                "h1 small,h2 small,h3 small,#toctitle small,.sidebarblock>.content>.title small,h4 small,h5 small,h6 small{font-size:60%;color:#e99b8f;line-height:0}\n" +
                "h1{font-size:2.125em}\n" +
                "h2{font-size:1.6875em}\n" +
                "h3,#toctitle,.sidebarblock>.content>.title{font-size:1.375em}\n" +
                "h4,h5{font-size:1.125em}\n" +
                "h6{font-size:1em}\n" +
                "hr{border:solid #dddddf;border-width:1px 0 0;clear:both;margin:1.25em 0 1.1875em;height:0}\n" +
                "em,i{font-style:italic;line-height:inherit}\n" +
                "strong,b{font-weight:bold;line-height:inherit}\n" +
                "small{font-size:60%;line-height:inherit}\n" +
                "code{font-family:\"Droid Sans Mono\",\"DejaVu Sans Mono\",monospace;font-weight:400;color:rgba(0,0,0,.9)}\n" +
                "ul,ol,dl{font-size:1em;line-height:1.6;margin-bottom:1.25em;list-style-position:outside;font-family:inherit}\n" +
                "ul,ol{margin-left:1.5em}\n" +
                "ul li ul,ul li ol{margin-left:1.25em;margin-bottom:0;font-size:1em}\n" +
                "ul.square li ul,ul.circle li ul,ul.disc li ul{list-style:inherit}\n" +
                "ul.square{list-style-type:square}\n" +
                "ul.circle{list-style-type:circle}\n" +
                "ul.disc{list-style-type:disc}\n" +
                "ol li ul,ol li ol{margin-left:1.25em;margin-bottom:0}\n" +
                "dl dt{margin-bottom:.3125em;font-weight:bold}\n" +
                "dl dd{margin-bottom:1.25em}\n" +
                "abbr,acronym{text-transform:uppercase;font-size:90%;color:rgba(0,0,0,.8);border-bottom:1px dotted #ddd;cursor:help}\n" +
                "abbr{text-transform:none}\n" +
                "blockquote{margin:0 0 1.25em;padding:.5625em 1.25em 0 1.1875em;border-left:1px solid #ddd}\n" +
                "blockquote cite{display:block;font-size:.9375em;color:rgba(0,0,0,.6)}\n" +
                "blockquote cite::before{content:\"\\2014 \\0020\"}\n" +
                "blockquote cite a,blockquote cite a:visited{color:rgba(0,0,0,.6)}\n" +
                "blockquote,blockquote p{line-height:1.6;color:rgba(0,0,0,.85)}\n" +
                "@media screen and (min-width:768px){h1,h2,h3,#toctitle,.sidebarblock>.content>.title,h4,h5,h6{line-height:1.2}\n" +
                "h1{font-size:2.75em}\n" +
                "h2{font-size:2.3125em}\n" +
                "h3,#toctitle,.sidebarblock>.content>.title{font-size:1.6875em}\n" +
                "h4{font-size:1.4375em}}\n" +
                "table{background:#fff;margin-bottom:1.25em;border:solid 1px #dedede}\n" +
                "table thead,table tfoot{background:#f7f8f7}\n" +
                "table thead tr th,table thead tr td,table tfoot tr th,table tfoot tr td{padding:.5em .625em .625em;font-size:inherit;color:rgba(0,0,0,.8);text-align:left}\n" +
                "table tr th,table tr td{padding:.5625em .625em;font-size:inherit;color:rgba(0,0,0,.8)}\n" +
                "table tr.even,table tr.alt,table tr:nth-of-type(even){background:#f8f8f7}\n" +
                "table thead tr th,table tfoot tr th,table tbody tr td,table tr td,table tfoot tr td{display:table-cell;line-height:1.6}\n" +
                "h1,h2,h3,#toctitle,.sidebarblock>.content>.title,h4,h5,h6{line-height:1.2;word-spacing:-.05em}\n" +
                "h1 strong,h2 strong,h3 strong,#toctitle strong,.sidebarblock>.content>.title strong,h4 strong,h5 strong,h6 strong{font-weight:400}\n" +
                ".clearfix::before,.clearfix::after,.float-group::before,.float-group::after{content:\" \";display:table}\n" +
                ".clearfix::after,.float-group::after{clear:both}\n" +
                "*:not(pre)>code{font-size:.9375em;font-style:normal!important;letter-spacing:0;padding:.1em .5ex;word-spacing:-.15em;background-color:#f7f7f8;-webkit-border-radius:4px;border-radius:4px;line-height:1.45;text-rendering:optimizeSpeed;word-wrap:break-word}\n" +
                "*:not(pre)>code.nobreak{word-wrap:normal}\n" +
                "*:not(pre)>code.nowrap{white-space:nowrap}\n" +
                "pre,pre>code{line-height:1.45;color:rgba(0,0,0,.9);font-family:\"Droid Sans Mono\",\"DejaVu Sans Mono\",monospace;font-weight:400;text-rendering:optimizeSpeed}\n" +
                "em em{font-style:normal}\n" +
                "strong strong{font-weight:400}\n" +
                ".keyseq{color:rgba(51,51,51,.8)}\n" +
                "kbd{font-family:\"Droid Sans Mono\",\"DejaVu Sans Mono\",monospace;display:inline-block;color:rgba(0,0,0,.8);font-size:.65em;line-height:1.45;background-color:#f7f7f7;border:1px solid #ccc;-webkit-border-radius:3px;border-radius:3px;-webkit-box-shadow:0 1px 0 rgba(0,0,0,.2),0 0 0 .1em white inset;box-shadow:0 1px 0 rgba(0,0,0,.2),0 0 0 .1em #fff inset;margin:0 .15em;padding:.2em .5em;vertical-align:middle;position:relative;top:-.1em;white-space:nowrap}\n" +
                ".keyseq kbd:first-child{margin-left:0}\n" +
                ".keyseq kbd:last-child{margin-right:0}\n" +
                ".menuseq,.menuref{color:#000}\n" +
                ".menuseq b:not(.caret),.menuref{font-weight:inherit}\n" +
                ".menuseq{word-spacing:-.02em}\n" +
                ".menuseq b.caret{font-size:1.25em;line-height:.8}\n" +
                ".menuseq i.caret{font-weight:bold;text-align:center;width:.45em}\n" +
                "b.button::before,b.button::after{position:relative;top:-1px;font-weight:400}\n" +
                "b.button::before{content:\"[\";padding:0 3px 0 2px}\n" +
                "b.button::after{content:\"]\";padding:0 2px 0 3px}\n" +
                "p a>code:hover{color:rgba(0,0,0,.9)}\n" +
                "#header,#content,#footnotes,#footer{width:100%;margin-left:auto;margin-right:auto;margin-top:0;margin-bottom:0;max-width:62.5em;*zoom:1;position:relative;padding-left:.9375em;padding-right:.9375em}\n" +
                "#header::before,#header::after,#content::before,#content::after,#footnotes::before,#footnotes::after,#footer::before,#footer::after{content:\" \";display:table}\n" +
                "#header::after,#content::after,#footnotes::after,#footer::after{clear:both}\n" +
                "#content{margin-top:1.25em}\n" +
                "#content::before{content:none}\n" +
                "#header>h1:first-child{color:rgba(0,0,0,.85);margin-top:2.25rem;margin-bottom:0}\n" +
                "#header>h1:first-child+#toc{margin-top:8px;border-top:1px solid #dddddf}\n" +
                "#header>h1:only-child,body.toc2 #header>h1:nth-last-child(2){border-bottom:1px solid #dddddf;padding-bottom:8px}\n" +
                "#header .details{border-bottom:1px solid #dddddf;line-height:1.45;padding-top:.25em;padding-bottom:.25em;padding-left:.25em;color:rgba(0,0,0,.6);display:-ms-flexbox;display:-webkit-flex;display:flex;-ms-flex-flow:row wrap;-webkit-flex-flow:row wrap;flex-flow:row wrap}\n" +
                "#header .details span:first-child{margin-left:-.125em}\n" +
                "#header .details span.email a{color:rgba(0,0,0,.85)}\n" +
                "#header .details br{display:none}\n" +
                "#header .details br+span::before{content:\"\\00a0\\2013\\00a0\"}\n" +
                "#header .details br+span.author::before{content:\"\\00a0\\22c5\\00a0\";color:rgba(0,0,0,.85)}\n" +
                "#header .details br+span#revremark::before{content:\"\\00a0|\\00a0\"}\n" +
                "#header #revnumber{text-transform:capitalize}\n" +
                "#header #revnumber::after{content:\"\\00a0\"}\n" +
                "#content>h1:first-child:not([class]){color:rgba(0,0,0,.85);border-bottom:1px solid #dddddf;padding-bottom:8px;margin-top:0;padding-top:1rem;margin-bottom:1.25rem}\n" +
                "#toc{border-bottom:1px solid #e7e7e9;padding-bottom:.5em}\n" +
                "#toc>ul{margin-left:.125em}\n" +
                "#toc ul.sectlevel0>li>a{font-style:italic}\n" +
                "#toc ul.sectlevel0 ul.sectlevel1{margin:.5em 0}\n" +
                "#toc ul{font-family:\"Open Sans\",\"DejaVu Sans\",sans-serif;list-style-type:none}\n" +
                "#toc li{line-height:1.3334;margin-top:.3334em}\n" +
                "#toc a{text-decoration:none}\n" +
                "#toc a:active{text-decoration:underline}\n" +
                "#toctitle{color:#7a2518;font-size:1.2em}\n" +
                "@media screen and (min-width:768px){#toctitle{font-size:1.375em}\n" +
                "body.toc2{padding-left:15em;padding-right:0}\n" +
                "#toc.toc2{margin-top:0!important;background-color:#f8f8f7;position:fixed;width:15em;left:0;top:0;border-right:1px solid #e7e7e9;border-top-width:0!important;border-bottom-width:0!important;z-index:1000;padding:1.25em 1em;height:100%;overflow:auto}\n" +
                "#toc.toc2 #toctitle{margin-top:0;margin-bottom:.8rem;font-size:1.2em}\n" +
                "#toc.toc2>ul{font-size:.9em;margin-bottom:0}\n" +
                "#toc.toc2 ul ul{margin-left:0;padding-left:1em}\n" +
                "#toc.toc2 ul.sectlevel0 ul.sectlevel1{padding-left:0;margin-top:.5em;margin-bottom:.5em}\n" +
                "body.toc2.toc-right{padding-left:0;padding-right:15em}\n" +
                "body.toc2.toc-right #toc.toc2{border-right-width:0;border-left:1px solid #e7e7e9;left:auto;right:0}}\n" +
                "@media screen and (min-width:1280px){body.toc2{padding-left:20em;padding-right:0}\n" +
                "#toc.toc2{width:20em}\n" +
                "#toc.toc2 #toctitle{font-size:1.375em}\n" +
                "#toc.toc2>ul{font-size:.95em}\n" +
                "#toc.toc2 ul ul{padding-left:1.25em}\n" +
                "body.toc2.toc-right{padding-left:0;padding-right:20em}}\n" +
                "#content #toc{border-style:solid;border-width:1px;border-color:#e0e0dc;margin-bottom:1.25em;padding:1.25em;background:#f8f8f7;-webkit-border-radius:4px;border-radius:4px}\n" +
                "#content #toc>:first-child{margin-top:0}\n" +
                "#content #toc>:last-child{margin-bottom:0}\n" +
                "#footer{max-width:100%;background-color:rgba(0,0,0,.8);padding:1.25em}\n" +
                "#footer-text{color:rgba(255,255,255,.8);line-height:1.44}\n" +
                "#content{margin-bottom:.625em}\n" +
                ".sect1{padding-bottom:.625em}\n" +
                "@media screen and (min-width:768px){#content{margin-bottom:1.25em}\n" +
                ".sect1{padding-bottom:1.25em}}\n" +
                ".sect1:last-child{padding-bottom:0}\n" +
                ".sect1+.sect1{border-top:1px solid #e7e7e9}\n" +
                "#content h1>a.anchor,h2>a.anchor,h3>a.anchor,#toctitle>a.anchor,.sidebarblock>.content>.title>a.anchor,h4>a.anchor,h5>a.anchor,h6>a.anchor{position:absolute;z-index:1001;width:1.5ex;margin-left:-1.5ex;display:block;text-decoration:none!important;visibility:hidden;text-align:center;font-weight:400}\n" +
                "#content h1>a.anchor::before,h2>a.anchor::before,h3>a.anchor::before,#toctitle>a.anchor::before,.sidebarblock>.content>.title>a.anchor::before,h4>a.anchor::before,h5>a.anchor::before,h6>a.anchor::before{content:\"\\00A7\";font-size:.85em;display:block;padding-top:.1em}\n" +
                "#content h1:hover>a.anchor,#content h1>a.anchor:hover,h2:hover>a.anchor,h2>a.anchor:hover,h3:hover>a.anchor,#toctitle:hover>a.anchor,.sidebarblock>.content>.title:hover>a.anchor,h3>a.anchor:hover,#toctitle>a.anchor:hover,.sidebarblock>.content>.title>a.anchor:hover,h4:hover>a.anchor,h4>a.anchor:hover,h5:hover>a.anchor,h5>a.anchor:hover,h6:hover>a.anchor,h6>a.anchor:hover{visibility:visible}\n" +
                "#content h1>a.link,h2>a.link,h3>a.link,#toctitle>a.link,.sidebarblock>.content>.title>a.link,h4>a.link,h5>a.link,h6>a.link{color:#ba3925;text-decoration:none}\n" +
                "#content h1>a.link:hover,h2>a.link:hover,h3>a.link:hover,#toctitle>a.link:hover,.sidebarblock>.content>.title>a.link:hover,h4>a.link:hover,h5>a.link:hover,h6>a.link:hover{color:#a53221}\n" +
                ".audioblock,.imageblock,.literalblock,.listingblock,.stemblock,.videoblock{margin-bottom:1.25em}\n" +
                ".admonitionblock td.content>.title,.audioblock>.title,.exampleblock>.title,.imageblock>.title,.listingblock>.title,.literalblock>.title,.stemblock>.title,.openblock>.title,.paragraph>.title,.quoteblock>.title,table.tableblock>.title,.verseblock>.title,.videoblock>.title,.dlist>.title,.olist>.title,.ulist>.title,.qlist>.title,.hdlist>.title{text-rendering:optimizeLegibility;text-align:left;font-family:\"Noto Serif\",\"DejaVu Serif\",serif;font-size:1rem;font-style:italic}\n" +
                "table.tableblock.fit-content>caption.title{white-space:nowrap;width:0}\n" +
                ".paragraph.lead>p,#preamble>.sectionbody>[class=\"paragraph\"]:first-of-type p{font-size:1.21875em;line-height:1.6;color:rgba(0,0,0,.85)}\n" +
                "table.tableblock #preamble>.sectionbody>[class=\"paragraph\"]:first-of-type p{font-size:inherit}\n" +
                ".admonitionblock>table{border-collapse:separate;border:0;background:none;width:100%}\n" +
                ".admonitionblock>table td.icon{text-align:center;width:80px}\n" +
                ".admonitionblock>table td.icon img{max-width:none}\n" +
                ".admonitionblock>table td.icon .title{font-weight:bold;font-family:\"Open Sans\",\"DejaVu Sans\",sans-serif;text-transform:uppercase}\n" +
                ".admonitionblock>table td.content{padding-left:1.125em;padding-right:1.25em;border-left:1px solid #dddddf;color:rgba(0,0,0,.6)}\n" +
                ".admonitionblock>table td.content>:last-child>:last-child{margin-bottom:0}\n" +
                ".exampleblock>.content{border-style:solid;border-width:1px;border-color:#e6e6e6;margin-bottom:1.25em;padding:1.25em;background:#fff;-webkit-border-radius:4px;border-radius:4px}\n" +
                ".exampleblock>.content>:first-child{margin-top:0}\n" +
                ".exampleblock>.content>:last-child{margin-bottom:0}\n" +
                ".sidebarblock{border-style:solid;border-width:1px;border-color:#e0e0dc;margin-bottom:1.25em;padding:1.25em;background:#f8f8f7;-webkit-border-radius:4px;border-radius:4px}\n" +
                ".sidebarblock>:first-child{margin-top:0}\n" +
                ".sidebarblock>:last-child{margin-bottom:0}\n" +
                ".sidebarblock>.content>.title{color:#7a2518;margin-top:0;text-align:center}\n" +
                ".exampleblock>.content>:last-child>:last-child,.exampleblock>.content .olist>ol>li:last-child>:last-child,.exampleblock>.content .ulist>ul>li:last-child>:last-child,.exampleblock>.content .qlist>ol>li:last-child>:last-child,.sidebarblock>.content>:last-child>:last-child,.sidebarblock>.content .olist>ol>li:last-child>:last-child,.sidebarblock>.content .ulist>ul>li:last-child>:last-child,.sidebarblock>.content .qlist>ol>li:last-child>:last-child{margin-bottom:0}\n" +
                ".literalblock pre,.listingblock pre:not(.highlight),.listingblock pre[class=\"highlight\"],.listingblock pre[class^=\"highlight \"],.listingblock pre.CodeRay,.listingblock pre.prettyprint{background:#f7f7f8}\n" +
                ".sidebarblock .literalblock pre,.sidebarblock .listingblock pre:not(.highlight),.sidebarblock .listingblock pre[class=\"highlight\"],.sidebarblock .listingblock pre[class^=\"highlight \"],.sidebarblock .listingblock pre.CodeRay,.sidebarblock .listingblock pre.prettyprint{background:#f2f1f1}\n" +
                ".literalblock pre,.literalblock pre[class],.listingblock pre,.listingblock pre[class]{-webkit-border-radius:4px;border-radius:4px;word-wrap:break-word;overflow-x:auto;padding:1em;font-size:.8125em}\n" +
                "@media screen and (min-width:768px){.literalblock pre,.literalblock pre[class],.listingblock pre,.listingblock pre[class]{font-size:.90625em}}\n" +
                "@media screen and (min-width:1280px){.literalblock pre,.literalblock pre[class],.listingblock pre,.listingblock pre[class]{font-size:1em}}\n" +
                ".literalblock pre.nowrap,.literalblock pre.nowrap pre,.listingblock pre.nowrap,.listingblock pre.nowrap pre{white-space:pre;word-wrap:normal}\n" +
                ".literalblock.output pre{color:#f7f7f8;background-color:rgba(0,0,0,.9)}\n" +
                ".listingblock pre.highlightjs{padding:0}\n" +
                ".listingblock pre.highlightjs>code{padding:1em;-webkit-border-radius:4px;border-radius:4px}\n" +
                ".listingblock pre.prettyprint{border-width:0}\n" +
                ".listingblock>.content{position:relative}\n" +
                ".listingblock code[data-lang]::before{display:none;content:attr(data-lang);position:absolute;font-size:.75em;top:.425rem;right:.5rem;line-height:1;text-transform:uppercase;color:#999}\n" +
                ".listingblock:hover code[data-lang]::before{display:block}\n" +
                ".listingblock.terminal pre .command::before{content:attr(data-prompt);padding-right:.5em;color:#999}\n" +
                ".listingblock.terminal pre .command:not([data-prompt])::before{content:\"$\"}\n" +
                "table.pyhltable{border-collapse:separate;border:0;margin-bottom:0;background:none}\n" +
                "table.pyhltable td{vertical-align:top;padding-top:0;padding-bottom:0;line-height:1.45}\n" +
                "table.pyhltable td.code{padding-left:.75em;padding-right:0}\n" +
                "pre.pygments .lineno,table.pyhltable td:not(.code){color:#999;padding-left:0;padding-right:.5em;border-right:1px solid #dddddf}\n" +
                "pre.pygments .lineno{display:inline-block;margin-right:.25em}\n" +
                "table.pyhltable .linenodiv{background:none!important;padding-right:0!important}\n" +
                ".quoteblock{margin:0 1em 1.25em 1.5em;display:table}\n" +
                ".quoteblock>.title{margin-left:-1.5em;margin-bottom:.75em}\n" +
                ".quoteblock blockquote,.quoteblock p{color:rgba(0,0,0,.85);font-size:1.15rem;line-height:1.75;word-spacing:.1em;letter-spacing:0;font-style:italic;text-align:justify}\n" +
                ".quoteblock blockquote{margin:0;padding:0;border:0}\n" +
                ".quoteblock blockquote::before{content:\"\\201c\";float:left;font-size:2.75em;font-weight:bold;line-height:.6em;margin-left:-.6em;color:#7a2518;text-shadow:0 1px 2px rgba(0,0,0,.1)}\n" +
                ".quoteblock blockquote>.paragraph:last-child p{margin-bottom:0}\n" +
                ".quoteblock .attribution{margin-top:.75em;margin-right:.5ex;text-align:right}\n" +
                ".verseblock{margin:0 1em 1.25em}\n" +
                ".verseblock pre{font-family:\"Open Sans\",\"DejaVu Sans\",sans;font-size:1.15rem;color:rgba(0,0,0,.85);font-weight:300;text-rendering:optimizeLegibility}\n" +
                ".verseblock pre strong{font-weight:400}\n" +
                ".verseblock .attribution{margin-top:1.25rem;margin-left:.5ex}\n" +
                ".quoteblock .attribution,.verseblock .attribution{font-size:.9375em;line-height:1.45;font-style:italic}\n" +
                ".quoteblock .attribution br,.verseblock .attribution br{display:none}\n" +
                ".quoteblock .attribution cite,.verseblock .attribution cite{display:block;letter-spacing:-.025em;color:rgba(0,0,0,.6)}\n" +
                ".quoteblock.abstract blockquote::before,.quoteblock.excerpt blockquote::before,.quoteblock .quoteblock blockquote::before{display:none}\n" +
                ".quoteblock.abstract blockquote,.quoteblock.abstract p,.quoteblock.excerpt blockquote,.quoteblock.excerpt p,.quoteblock .quoteblock blockquote,.quoteblock .quoteblock p{line-height:1.6;word-spacing:0}\n" +
                ".quoteblock.abstract{margin:0 1em 1.25em;display:block}\n" +
                ".quoteblock.abstract>.title{margin:0 0 .375em;font-size:1.15em;text-align:center}\n" +
                ".quoteblock.excerpt,.quoteblock .quoteblock{margin:0 0 1.25em;padding:0 0 .25em 1em;border-left:.25em solid #dddddf}\n" +
                ".quoteblock.excerpt blockquote,.quoteblock.excerpt p,.quoteblock .quoteblock blockquote,.quoteblock .quoteblock p{color:inherit;font-size:1.0625rem}\n" +
                ".quoteblock.excerpt .attribution,.quoteblock .quoteblock .attribution{color:inherit;text-align:left;margin-right:0}\n" +
                "table.tableblock{max-width:100%;border-collapse:separate}\n" +
                "p.tableblock:last-child{margin-bottom:0}\n" +
                "td.tableblock>.content{margin-bottom:-1.25em}\n" +
                "table.tableblock,th.tableblock,td.tableblock{border:0 solid #dedede}\n" +
                "table.grid-all>thead>tr>.tableblock,table.grid-all>tbody>tr>.tableblock{border-width:0 1px 1px 0}\n" +
                "table.grid-all>tfoot>tr>.tableblock{border-width:1px 1px 0 0}\n" +
                "table.grid-cols>*>tr>.tableblock{border-width:0 1px 0 0}\n" +
                "table.grid-rows>thead>tr>.tableblock,table.grid-rows>tbody>tr>.tableblock{border-width:0 0 1px}\n" +
                "table.grid-rows>tfoot>tr>.tableblock{border-width:1px 0 0}\n" +
                "table.grid-all>*>tr>.tableblock:last-child,table.grid-cols>*>tr>.tableblock:last-child{border-right-width:0}\n" +
                "table.grid-all>tbody>tr:last-child>.tableblock,table.grid-all>thead:last-child>tr>.tableblock,table.grid-rows>tbody>tr:last-child>.tableblock,table.grid-rows>thead:last-child>tr>.tableblock{border-bottom-width:0}\n" +
                "table.frame-all{border-width:1px}\n" +
                "table.frame-sides{border-width:0 1px}\n" +
                "table.frame-topbot,table.frame-ends{border-width:1px 0}\n" +
                "table.stripes-all tr,table.stripes-odd tr:nth-of-type(odd){background:#f8f8f7}\n" +
                "table.stripes-none tr,table.stripes-odd tr:nth-of-type(even){background:none}\n" +
                "th.halign-left,td.halign-left{text-align:left}\n" +
                "th.halign-right,td.halign-right{text-align:right}\n" +
                "th.halign-center,td.halign-center{text-align:center}\n" +
                "th.valign-top,td.valign-top{vertical-align:top}\n" +
                "th.valign-bottom,td.valign-bottom{vertical-align:bottom}\n" +
                "th.valign-middle,td.valign-middle{vertical-align:middle}\n" +
                "table thead th,table tfoot th{font-weight:bold}\n" +
                "tbody tr th{display:table-cell;line-height:1.6;background:#f7f8f7}\n" +
                "tbody tr th,tbody tr th p,tfoot tr th,tfoot tr th p{color:rgba(0,0,0,.8);font-weight:bold}\n" +
                "p.tableblock>code:only-child{background:none;padding:0}\n" +
                "p.tableblock{font-size:1em}\n" +
                "td>div.verse{white-space:pre}\n" +
                "ol{margin-left:1.75em}\n" +
                "ul li ol{margin-left:1.5em}\n" +
                "dl dd{margin-left:1.125em}\n" +
                "dl dd:last-child,dl dd:last-child>:last-child{margin-bottom:0}\n" +
                "ol>li p,ul>li p,ul dd,ol dd,.olist .olist,.ulist .ulist,.ulist .olist,.olist .ulist{margin-bottom:.625em}\n" +
                "ul.checklist,ul.none,ol.none,ul.no-bullet,ol.no-bullet,ol.unnumbered,ul.unstyled,ol.unstyled{list-style-type:none}\n" +
                "ul.no-bullet,ol.no-bullet,ol.unnumbered{margin-left:.625em}\n" +
                "ul.unstyled,ol.unstyled{margin-left:0}\n" +
                "ul.checklist{margin-left:.625em}\n" +
                "ul.checklist li>p:first-child>.fa-square-o:first-child,ul.checklist li>p:first-child>.fa-check-square-o:first-child{width:1.25em;font-size:.8em;position:relative;bottom:.125em}\n" +
                "ul.checklist li>p:first-child>input[type=\"checkbox\"]:first-child{margin-right:.25em}\n" +
                "ul.inline{display:-ms-flexbox;display:-webkit-box;display:flex;-ms-flex-flow:row wrap;-webkit-flex-flow:row wrap;flex-flow:row wrap;list-style:none;margin:0 0 .625em -1.25em}\n" +
                "ul.inline>li{margin-left:1.25em}\n" +
                ".unstyled dl dt{font-weight:400;font-style:normal}\n" +
                "ol.arabic{list-style-type:decimal}\n" +
                "ol.decimal{list-style-type:decimal-leading-zero}\n" +
                "ol.loweralpha{list-style-type:lower-alpha}\n" +
                "ol.upperalpha{list-style-type:upper-alpha}\n" +
                "ol.lowerroman{list-style-type:lower-roman}\n" +
                "ol.upperroman{list-style-type:upper-roman}\n" +
                "ol.lowergreek{list-style-type:lower-greek}\n" +
                ".hdlist>table,.colist>table{border:0;background:none}\n" +
                ".hdlist>table>tbody>tr,.colist>table>tbody>tr{background:none}\n" +
                "td.hdlist1,td.hdlist2{vertical-align:top;padding:0 .625em}\n" +
                "td.hdlist1{font-weight:bold;padding-bottom:1.25em}\n" +
                ".literalblock+.colist,.listingblock+.colist{margin-top:-.5em}\n" +
                ".colist td:not([class]):first-child{padding:.4em .75em 0;line-height:1;vertical-align:top}\n" +
                ".colist td:not([class]):first-child img{max-width:none}\n" +
                ".colist td:not([class]):last-child{padding:.25em 0}\n" +
                ".thumb,.th{line-height:0;display:inline-block;border:solid 4px #fff;-webkit-box-shadow:0 0 0 1px #ddd;box-shadow:0 0 0 1px #ddd}\n" +
                ".imageblock.left{margin:.25em .625em 1.25em 0}\n" +
                ".imageblock.right{margin:.25em 0 1.25em .625em}\n" +
                ".imageblock>.title{margin-bottom:0}\n" +
                ".imageblock.thumb,.imageblock.th{border-width:6px}\n" +
                ".imageblock.thumb>.title,.imageblock.th>.title{padding:0 .125em}\n" +
                ".image.left,.image.right{margin-top:.25em;margin-bottom:.25em;display:inline-block;line-height:0}\n" +
                ".image.left{margin-right:.625em}\n" +
                ".image.right{margin-left:.625em}\n" +
                "a.image{text-decoration:none;display:inline-block}\n" +
                "a.image object{pointer-events:none}\n" +
                "sup.footnote,sup.footnoteref{font-size:.875em;position:static;vertical-align:super}\n" +
                "sup.footnote a,sup.footnoteref a{text-decoration:none}\n" +
                "sup.footnote a:active,sup.footnoteref a:active{text-decoration:underline}\n" +
                "#footnotes{padding-top:.75em;padding-bottom:.75em;margin-bottom:.625em}\n" +
                "#footnotes hr{width:20%;min-width:6.25em;margin:-.25em 0 .75em;border-width:1px 0 0}\n" +
                "#footnotes .footnote{padding:0 .375em 0 .225em;line-height:1.3334;font-size:.875em;margin-left:1.2em;margin-bottom:.2em}\n" +
                "#footnotes .footnote a:first-of-type{font-weight:bold;text-decoration:none;margin-left:-1.05em}\n" +
                "#footnotes .footnote:last-of-type{margin-bottom:0}\n" +
                "#content #footnotes{margin-top:-.625em;margin-bottom:0;padding:.75em 0}\n" +
                ".gist .file-data>table{border:0;background:#fff;width:100%;margin-bottom:0}\n" +
                ".gist .file-data>table td.line-data{width:99%}\n" +
                "div.unbreakable{page-break-inside:avoid}\n" +
                ".big{font-size:larger}\n" +
                ".small{font-size:smaller}\n" +
                ".underline{text-decoration:underline}\n" +
                ".overline{text-decoration:overline}\n" +
                ".line-through{text-decoration:line-through}\n" +
                ".aqua{color:#00bfbf}\n" +
                ".aqua-background{background-color:#00fafa}\n" +
                ".black{color:#000}\n" +
                ".black-background{background-color:#000}\n" +
                ".blue{color:#0000bf}\n" +
                ".blue-background{background-color:#0000fa}\n" +
                ".fuchsia{color:#bf00bf}\n" +
                ".fuchsia-background{background-color:#fa00fa}\n" +
                ".gray{color:#606060}\n" +
                ".gray-background{background-color:#7d7d7d}\n" +
                ".green{color:#006000}\n" +
                ".green-background{background-color:#007d00}\n" +
                ".lime{color:#00bf00}\n" +
                ".lime-background{background-color:#00fa00}\n" +
                ".maroon{color:#600000}\n" +
                ".maroon-background{background-color:#7d0000}\n" +
                ".navy{color:#000060}\n" +
                ".navy-background{background-color:#00007d}\n" +
                ".olive{color:#606000}\n" +
                ".olive-background{background-color:#7d7d00}\n" +
                ".purple{color:#600060}\n" +
                ".purple-background{background-color:#7d007d}\n" +
                ".red{color:#bf0000}\n" +
                ".red-background{background-color:#fa0000}\n" +
                ".silver{color:#909090}\n" +
                ".silver-background{background-color:#bcbcbc}\n" +
                ".teal{color:#006060}\n" +
                ".teal-background{background-color:#007d7d}\n" +
                ".white{color:#bfbfbf}\n" +
                ".white-background{background-color:#fafafa}\n" +
                ".yellow{color:#bfbf00}\n" +
                ".yellow-background{background-color:#fafa00}\n" +
                "span.icon>.fa{cursor:default}\n" +
                "a span.icon>.fa{cursor:inherit}\n" +
                ".admonitionblock td.icon [class^=\"fa icon-\"]{font-size:2.5em;text-shadow:1px 1px 2px rgba(0,0,0,.5);cursor:default}\n" +
                ".admonitionblock td.icon .icon-note::before{content:\"\\f05a\";color:#19407c}\n" +
                ".admonitionblock td.icon .icon-tip::before{content:\"\\f0eb\";text-shadow:1px 1px 2px rgba(155,155,0,.8);color:#111}\n" +
                ".admonitionblock td.icon .icon-warning::before{content:\"\\f071\";color:#bf6900}\n" +
                ".admonitionblock td.icon .icon-caution::before{content:\"\\f06d\";color:#bf3400}\n" +
                ".admonitionblock td.icon .icon-important::before{content:\"\\f06a\";color:#bf0000}\n" +
                ".conum[data-value]{display:inline-block;color:#fff!important;background-color:rgba(0,0,0,.8);-webkit-border-radius:100px;border-radius:100px;text-align:center;font-size:.75em;width:1.67em;height:1.67em;line-height:1.67em;font-family:\"Open Sans\",\"DejaVu Sans\",sans-serif;font-style:normal;font-weight:bold}\n" +
                ".conum[data-value] *{color:#fff!important}\n" +
                ".conum[data-value]+b{display:none}\n" +
                ".conum[data-value]::after{content:attr(data-value)}\n" +
                "pre .conum[data-value]{position:relative;top:-.125em}\n" +
                "b.conum *{color:inherit!important}\n" +
                ".conum:not([data-value]):empty{display:none}\n" +
                "dt,th.tableblock,td.content,div.footnote{text-rendering:optimizeLegibility}\n" +
                "h1,h2,p,td.content,span.alt{letter-spacing:-.01em}\n" +
                "p strong,td.content strong,div.footnote strong{letter-spacing:-.005em}\n" +
                "p,blockquote,dt,td.content,span.alt{font-size:1.0625rem}\n" +
                "p{margin-bottom:1.25rem}\n" +
                ".sidebarblock p,.sidebarblock dt,.sidebarblock td.content,p.tableblock{font-size:1em}\n" +
                ".exampleblock>.content{background-color:#fffef7;border-color:#e0e0dc;-webkit-box-shadow:0 1px 4px #e0e0dc;box-shadow:0 1px 4px #e0e0dc}\n" +
                ".print-only{display:none!important}\n" +
                "@page{margin:1.25cm .75cm}\n" +
                "@media print{*{-webkit-box-shadow:none!important;box-shadow:none!important;text-shadow:none!important}\n" +
                "html{font-size:80%}\n" +
                "a{color:inherit!important;text-decoration:underline!important}\n" +
                "a.bare,a[href^=\"#\"],a[href^=\"mailto:\"]{text-decoration:none!important}\n" +
                "a[href^=\"http:\"]:not(.bare)::after,a[href^=\"https:\"]:not(.bare)::after{content:\"(\" attr(href) \")\";display:inline-block;font-size:.875em;padding-left:.25em}\n" +
                "abbr[title]::after{content:\" (\" attr(title) \")\"}\n" +
                "pre,blockquote,tr,img,object,svg{page-break-inside:avoid}\n" +
                "thead{display:table-header-group}\n" +
                "svg{max-width:100%}\n" +
                "p,blockquote,dt,td.content{font-size:1em;orphans:3;widows:3}\n" +
                "h2,h3,#toctitle,.sidebarblock>.content>.title{page-break-after:avoid}\n" +
                "#toc,.sidebarblock,.exampleblock>.content{background:none!important}\n" +
                "#toc{border-bottom:1px solid #dddddf!important;padding-bottom:0!important}\n" +
                "body.book #header{text-align:center}\n" +
                "body.book #header>h1:first-child{border:0!important;margin:2.5em 0 1em}\n" +
                "body.book #header .details{border:0!important;display:block;padding:0!important}\n" +
                "body.book #header .details span:first-child{margin-left:0!important}\n" +
                "body.book #header .details br{display:block}\n" +
                "body.book #header .details br+span::before{content:none!important}\n" +
                "body.book #toc{border:0!important;text-align:left!important;padding:0!important;margin:0!important}\n" +
                "body.book #toc,body.book #preamble,body.book h1.sect0,body.book .sect1>h2{page-break-before:always}\n" +
                ".listingblock code[data-lang]::before{display:block}\n" +
                "#footer{padding:0 .9375em}\n" +
                ".hide-on-print{display:none!important}\n" +
                ".print-only{display:block!important}\n" +
                ".hide-for-print{display:none!important}\n" +
                ".show-for-print{display:inherit!important}}\n" +
                "@media print,amzn-kf8{#header>h1:first-child{margin-top:1.25rem}\n" +
                ".sect1{padding:0!important}\n" +
                ".sect1+.sect1{border:0}\n" +
                "#footer{background:none}\n" +
                "#footer-text{color:rgba(0,0,0,.6);font-size:.9em}}\n" +
                "@media amzn-kf8{#header,#content,#footnotes,#footer{padding:0}}\n" +
                "</style>\n" +
                "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "</head>\n" +
                "<body class=\"book\">\n" +
                "<div id=\"header\">\n" +
                "<h1>WebService CarDealer</h1>\n" +
                "<div class=\"details\">\n" +
                "<span id=\"author\" class=\"author\">Benjamin Boson, Oscar Johanneson</span><br>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div id=\"content\">\n" +
                "<div id=\"preamble\">\n" +
                "<div class=\"sectionbody\">\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>CarController</code></p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>GET CARS</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>One showing how to make a request using cUrl:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-bash hljs\" data-lang=\"bash\">$ curl 'http://localhost:8080/api/v1/dealer/cars' -i -X GET \\\n" +
                "    -H 'Accept: application/json'</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>One showing HTTP request:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code class=\"language-http hljs\" data-lang=\"http\">GET /api/v1/dealer/cars HTTP/1.1\n" +
                "Accept: application/json\n" +
                "Host: localhost:8080</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>And one showing the HTTP response:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code class=\"language-http hljs\" data-lang=\"http\">HTTP/1.1 200 OK\n" +
                "Content-Type: application/json\n" +
                "X-Content-Type-Options: nosniff\n" +
                "X-XSS-Protection: 1; mode=block\n" +
                "Cache-Control: no-cache, no-store, max-age=0, must-revalidate\n" +
                "Pragma: no-cache\n" +
                "Expires: 0\n" +
                "X-Frame-Options: DENY\n" +
                "Content-Length: 171\n" +
                "\n" +
                "[{\"carId\":null,\"registrationNumber\":null,\"brand\":null,\"model\":null,\"color\":null,\"yearModel\":null,\"engine\":null,\"tires\":null,\"sold\":false,\"inStock\":false,\"reserved\":false}]</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>Response Body:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code>[{\"carId\":null,\"registrationNumber\":null,\"brand\":null,\"model\":null,\"color\":null,\"yearModel\":null,\"engine\":null,\"tires\":null,\"sold\":false,\"inStock\":false,\"reserved\":false}]</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>GET CAR</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>One showing how to make a request using cURL:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-bash hljs\" data-lang=\"bash\">$ curl 'http://localhost:8080/api/v1/dealer/cars/8d9853be-3ecf-47a0-bb0b-fa3f7b18040a' -i -X GET \\\n" +
                "    -H 'Accept: application/json'</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>One showing the HTTP request:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code class=\"language-http hljs\" data-lang=\"http\">GET /api/v1/dealer/cars/8d9853be-3ecf-47a0-bb0b-fa3f7b18040a HTTP/1.1\n" +
                "Accept: application/json\n" +
                "Host: localhost:8080</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>And one showing the HTTP response:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code class=\"language-http hljs\" data-lang=\"http\">HTTP/1.1 200 OK\n" +
                "Content-Type: application/json\n" +
                "X-Content-Type-Options: nosniff\n" +
                "X-XSS-Protection: 1; mode=block\n" +
                "Cache-Control: no-cache, no-store, max-age=0, must-revalidate\n" +
                "Pragma: no-cache\n" +
                "Expires: 0\n" +
                "X-Frame-Options: DENY\n" +
                "Content-Length: 169\n" +
                "\n" +
                "{\"carId\":null,\"registrationNumber\":null,\"brand\":null,\"model\":null,\"color\":null,\"yearModel\":null,\"engine\":null,\"tires\":null,\"sold\":false,\"inStock\":false,\"reserved\":false}</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>Response Body:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code>{\"carId\":null,\"registrationNumber\":null,\"brand\":null,\"model\":null,\"color\":null,\"yearModel\":null,\"engine\":null,\"tires\":null,\"sold\":false,\"inStock\":false,\"reserved\":false}</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>Response Fields:</p>\n" +
                "</div>\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3334%;\">\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">Path</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">Type</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">Description</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>carId</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car ID</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>registrationNumber</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car registration number</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>brand</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car brand</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>model</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car model</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>color</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car color</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>yearModel</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Year the of creation</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>engine</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>class com.example.webservices_cardealer.entities.Engine</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car engine type</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>tires</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>class com.example.webservices_cardealer.entities.Tires</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car tires type</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>sold</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>inStock</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>reserved</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>SAVE CAR</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>One showing how to make a request using cURL:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-bash hljs\" data-lang=\"bash\">$ curl 'http://localhost:8080/api/v1/dealer/cars' -i -X POST \\\n" +
                "    -H 'Content-Type: application/json' \\\n" +
                "    -d '{\"carId\":null,\"registrationNumber\":\"ABC123\",\"brand\":\"Volvo\",\"model\":\"V90\",\"color\":\"Black\",\"yearModel\":\"2020\",\"engine\":null,\"tires\":null,\"sold\":false,\"inStock\":true,\"reserved\":false}'</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>One showing the HTTP request:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code class=\"language-http hljs\" data-lang=\"http\">POST /api/v1/dealer/cars HTTP/1.1\n" +
                "Content-Type: application/json\n" +
                "Content-Length: 181\n" +
                "Host: localhost:8080\n" +
                "\n" +
                "{\"carId\":null,\"registrationNumber\":\"ABC123\",\"brand\":\"Volvo\",\"model\":\"V90\",\"color\":\"Black\",\"yearModel\":\"2020\",\"engine\":null,\"tires\":null,\"sold\":false,\"inStock\":true,\"reserved\":false}</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>And one showing the HTTP response:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code class=\"language-http hljs\" data-lang=\"http\">HTTP/1.1 201 Created\n" +
                "Location: /api/v1/dealer/cars/null\n" +
                "Content-Type: application/json\n" +
                "X-Content-Type-Options: nosniff\n" +
                "X-XSS-Protection: 1; mode=block\n" +
                "Cache-Control: no-cache, no-store, max-age=0, must-revalidate\n" +
                "Pragma: no-cache\n" +
                "Expires: 0\n" +
                "X-Frame-Options: DENY\n" +
                "Content-Length: 169\n" +
                "\n" +
                "{\"carId\":null,\"registrationNumber\":null,\"brand\":null,\"model\":null,\"color\":null,\"yearModel\":null,\"engine\":null,\"tires\":null,\"sold\":false,\"inStock\":false,\"reserved\":false}</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>Response Body:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code>{\"carId\":null,\"registrationNumber\":null,\"brand\":null,\"model\":null,\"color\":null,\"yearModel\":null,\"engine\":null,\"tires\":null,\"sold\":false,\"inStock\":false,\"reserved\":false}</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>Request Fields:</p>\n" +
                "</div>\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3334%;\">\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">Path</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">Type</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">Description</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>registrationNumber</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>String</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car registration number</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>brand</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>String</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car brand</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>model</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>String</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car brand</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>color</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>String</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car color</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>yearModel</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>String</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Year of the creation</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>engine</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car engine type</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>tires</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car tires type</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>sold</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>inStock</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>reserved</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>Response Fields:</p>\n" +
                "</div>\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3334%;\">\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">Path</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">Type</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">Description</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>carId</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car ID</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>registrationNumber</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car registration number</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>brand</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car brand</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>model</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car model</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>color</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car color</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>yearModel</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Year the of creation</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>engine</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>class com.example.webservices_cardealer.entities.Engine</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car engine type</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>tires</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>class com.example.webservices_cardealer.entities.Tires</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car tires type</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>sold</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>inStock</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>reserved</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>UPDATE CAR</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>One showing how to make a request using cURL:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-bash hljs\" data-lang=\"bash\">$ curl 'http://localhost:8080/api/v1/dealer/cars/5854a457-43c5-4c5c-816a-211c90e5e4eb' -i -X PUT \\\n" +
                "    -H 'Content-Type: application/json' \\\n" +
                "    -d '{\"carId\":\"4c4f667c-d453-4ef4-bf29-94f424fcd747\",\"registrationNumber\":\"ABC123\",\"brand\":\"Volvo\",\"model\":\"V90\",\"color\":\"Black\",\"yearModel\":\"2020\",\"engine\":null,\"tires\":null,\"sold\":false,\"inStock\":true,\"reserved\":false}'</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>One showing the HTTP request:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code class=\"language-http hljs\" data-lang=\"http\">PUT /api/v1/dealer/cars/5854a457-43c5-4c5c-816a-211c90e5e4eb HTTP/1.1\n" +
                "Content-Type: application/json\n" +
                "Content-Length: 215\n" +
                "Host: localhost:8080\n" +
                "\n" +
                "{\"carId\":\"4c4f667c-d453-4ef4-bf29-94f424fcd747\",\"registrationNumber\":\"ABC123\",\"brand\":\"Volvo\",\"model\":\"V90\",\"color\":\"Black\",\"yearModel\":\"2020\",\"engine\":null,\"tires\":null,\"sold\":false,\"inStock\":true,\"reserved\":false}</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>And one showing the HTTP response:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code class=\"language-http hljs\" data-lang=\"http\">HTTP/1.1 204 No Content\n" +
                "X-Content-Type-Options: nosniff\n" +
                "X-XSS-Protection: 1; mode=block\n" +
                "Cache-Control: no-cache, no-store, max-age=0, must-revalidate\n" +
                "Pragma: no-cache\n" +
                "Expires: 0\n" +
                "X-Frame-Options: DENY</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>Request Fields</p>\n" +
                "</div>\n" +
                "<table class=\"tableblock frame-all grid-all stretch\">\n" +
                "<colgroup>\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3333%;\">\n" +
                "<col style=\"width: 33.3334%;\">\n" +
                "</colgroup>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th class=\"tableblock halign-left valign-top\">Path</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">Type</th>\n" +
                "<th class=\"tableblock halign-left valign-top\">Description</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>registrationNumber</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>String</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car registration number</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>brand</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>String</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car brand</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>model</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>String</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car brand</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>color</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>String</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car color</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>yearModel</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>String</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Year of the creation</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>engine</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car engine type</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>tires</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Null</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Car tires type</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>sold</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>inStock</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>reserved</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\"><code>Boolean</code></p></td>\n" +
                "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">true/false</p></td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>DELETE CAR</p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>One showing how to make a request using cURL:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight\"><code class=\"language-bash hljs\" data-lang=\"bash\">$ curl 'http://localhost:8080/api/v1/dealer/cars/896de655-fa6a-42cb-9637-075f080c2cdd' -i -X DELETE \\\n" +
                "    -H 'Accept: application/json'</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>One showing the HTTP request:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code class=\"language-http hljs\" data-lang=\"http\">DELETE /api/v1/dealer/cars/896de655-fa6a-42cb-9637-075f080c2cdd HTTP/1.1\n" +
                "Accept: application/json\n" +
                "Host: localhost:8080</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p>And one showing the HTTP response:</p>\n" +
                "</div>\n" +
                "<div class=\"listingblock\">\n" +
                "<div class=\"content\">\n" +
                "<pre class=\"highlightjs highlight nowrap\"><code class=\"language-http hljs\" data-lang=\"http\">HTTP/1.1 204 No Content\n" +
                "X-Content-Type-Options: nosniff\n" +
                "X-XSS-Protection: 1; mode=block\n" +
                "Cache-Control: no-cache, no-store, max-age=0, must-revalidate\n" +
                "Pragma: no-cache\n" +
                "Expires: 0\n" +
                "X-Frame-Options: DENY</code></pre>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>EmployeeController</code></p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>EngineController</code></p>\n" +
                "</div>\n" +
                "<div class=\"paragraph\">\n" +
                "<p><code>TiresController</code></p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "</div>\n" +
                "<div id=\"footer\">\n" +
                "<div id=\"footer-text\">\n" +
                "Last updated 2020-11-02 15:36:43 +0100\n" +
                "</div>\n" +
                "</div>\n" +
                "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.13.1/styles/github.min.css\">\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.13.1/highlight.min.js\"></script>\n" +
                "<script>hljs.initHighlighting()</script>\n" +
                "</body>\n" +
                "</html>";
    }
}
