package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.Models.News;
import com.aclic.lottery.Models.User;
import com.aclic.lottery.Utils.Utils;
import com.aclic.lottery.services.CommentService;
import com.aclic.lottery.services.NewsService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author Aclic
 */
@Controller
public class NewsController {

    //数据库timestamp , 默认CURRENT_TIMESTAMP
    //model 使用 java.Util.Date

    @Autowired
    NewsService newsService;
    @Autowired
    CommentService commentService;

    //crud
    @ResponseBody
    @RequestMapping("/getNews")
    public List<News> getUsers(){
        return newsService.getUsers();
    }
    @ResponseBody
    @RequestMapping("/addNews")
    public int addUser(News u){//✔
        for(int i = 0; i<100 ;i++){
            News news = new News(Utils.genUUID()
                    ,"title" + i ,
                    "原标题：对华“求偿”诉讼闹剧在美上演，专家：个别国家针对中国的声音很大程度是为了“甩锅”\n" +
                    "\n" +
                    "　　[环球时报记者 赵觉珵 李萌 本报特约记者 鹿文]受讼棍团体的怂恿以及不良社会舆论的引导，美国民间近日新增多起集体诉讼案闹剧。“原告们”罔顾中国在全球抗疫一线发挥的重要作用，公然叫嚣让中国对他们的损失进行所谓的“赔偿”。\n" +
                    "\n" +
                    "　　美国媒体9日报道称，最近几周来，美国佛罗里达州正酝酿一波大规模的集体诉讼，截至近日该州的“原告团”已经超过5000人。这些美国人言之凿凿地表示，中国政府在疫情控制方面存在所谓的“失职”情节，要求中国赔付他们在新冠肺炎疫情期间所蒙受的各类损失。据了解，类似的民间集体诉讼近日也出现在美国内华达州和得克萨斯州。另据福克斯新闻网报道，加利福尼亚州几个名不见经传的小型企业近期更是狮子大开口，试图通过一场集体诉讼向中国政府、中国国家卫健委以及武汉市政部门索赔高达8万亿美元。\n" +
                    "\n" +
                    "　　在这一系列荒谬的集体诉讼案背后，媒体发现一家名为“伯曼法律集团”的地方性律所格外活跃。这家律所坐落于佛罗里达州小城博卡拉顿，官方网站号称其擅于事故索赔类官司，承接离婚纠纷、商业纠纷以及集体诉讼。不过一些公众点评网站显示，不少人都曾给该律所打出过“一星差评”，批评该机构“组织混乱、缺乏沟通”，很多从业者缺乏应有的专业素养。美国法律行业网站“TopClassactions”显示，该律所早在今年3月中旬就已开始承接针对中国的集体诉讼案，而当时该公司所受理的5个原告方，没有任何一方受到新冠病毒的直接影响。\n" +
                    "\n" +
                    "　　“伯曼法律集团”近日在接受美媒采访时称，对于最新的集体诉讼案，该律所将援引美国《外国主权豁免法》（FSIA）中涉及“商业活动”及“人身伤害”相关条款作为法律依据状告中国。然而加州大学黑斯廷斯法学院教授凯特纳表示，这套诉讼逻辑根本不成立。她说：“如果依照这部法律状告中国某位官员，那相关的违法行为需要发生在美国领土范围，这个前提已经是清楚得不能再清楚了。”她还补充说：“你总不能因别国做出相关政治决策，就提起法律诉讼吧。”也有网络舆论讽刺称，该律所大概是不明白何谓“主权豁免权”。", 99);
            newsService.addUser(news);
        }
        return 1;
    }
    @ResponseBody
    @RequestMapping("delNews")
    public int delUser(String id){//✔
        return newsService.delUser("adf");
    }
    @ResponseBody
    @RequestMapping("/modNews")
    public int modUser(User u){//改了
        News news = new News("sdjfk1","adf", "改了", 20);
        return newsService.modUser(news);
    }

  //初始news
    @RequestMapping("/getNewsPage")
    public String getNewsPage(Model model){
        List<News> newsList = newsService.lazyGetNews(0);
        model.addAttribute("newsList", newsList);
        return "news";
    }


    //懒加载
    @ResponseBody
    @RequestMapping("/lazyGetNews")
    public List<News> lazyGetNews(int start){
        List<News> newsList = newsService.lazyGetNews(start);
        return newsList;
    }

    //newsDetail
    @RequestMapping("/getNewsDetail")
    public String getNewsDetail(Model model, String newsId){
        //newsDetail
        News newsInfo = newsService.findOne(newsId);
        model.addAttribute("news", newsInfo);
        //relative comments
        List<Comment> comments = commentService.findSerious(newsId);
        model.addAttribute("comments", comments);
        return "newsDetail";
    }

}
