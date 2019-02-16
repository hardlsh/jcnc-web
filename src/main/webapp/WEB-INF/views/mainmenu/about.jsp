<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="../basepath.jsp"%>


<div class="row">
    <div class="col-md-12 content pull-right">
        <div class="text-holder">
            <div class="sec-title-two">
                <h1>金诚核心价值观</h1>
                <span class="border"></span>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="single-item">
                        <div class="icon-box">
                            <div class="custom-thumb-up"></div>
                        </div>
                        <div class="text-box">
                            <h3>客户第一</h3>
                            <p>微笑服务、注重倾听，不打断客户，在公司服务中做到客户为先；积极主动地为客户解决问题；
                               站在客户的立场考虑问题，让客户体验到满意的服务
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="single-item">
                        <div class="icon-box">
                            <div class="custom-heart"></div>
                        </div>
                        <div class="text-box">
                            <h3>感恩奉献</h3>
                            <p>
                                坚持以客户需求为先导，以诚信双赢为坚实基础，尽全力为客户提供耐材领域的帮助
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="sec-title-two">
            <h1>金诚耐材简介</h1>
            <span class="border"></span>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="single-item">
                    <div class="text-box">
                        <p>
                            北海金诚耐材有限公司，位于河南省新密市。耐火砖规格齐全，以高铝砖为核心，专注耐火原料，铝粉石、浇注料、粘土砖、异型砖，关于价格，咨询电话：15838055811。
                            公司诚信第一，用户至上，以高质量的产品和优质的售后服务，欢迎新老客户咨询交流，洽谈合作。
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    var mainMenu = '${mainMenu}';
    $('[name="custom_menu"]').each(function (index, entity) {
        $(entity).removeClass();
    });

    $('#' + mainMenu).addClass("active");
</script>