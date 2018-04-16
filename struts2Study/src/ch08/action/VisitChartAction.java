package ch08.action;

import com.opensymphony.xwork2.ActionSupport;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

public class VisitChartAction extends ActionSupport {

    private JFreeChart chart;

    public String execute()throws Exception{
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String seriesNewVisit = "New Visit Count";
        String seriesReVisit = "Re Visit Count";

        dataset.addValue(100,seriesNewVisit,"2018-04-01");
        dataset.addValue(253,seriesNewVisit,"2018-04-02");
        dataset.addValue(78,seriesNewVisit,"2018-04-03");
        dataset.addValue(133,seriesNewVisit,"2018-04-04");
        dataset.addValue(312,seriesNewVisit,"2018-04-05");
        dataset.addValue(42,seriesNewVisit,"2018-04-06");
        dataset.addValue(29,seriesNewVisit,"2018-04-07");

        dataset.addValue(56,seriesReVisit,"2018-04-01");
        dataset.addValue(132,seriesReVisit,"2018-04-02");
        dataset.addValue(52,seriesReVisit,"2018-04-03");
        dataset.addValue(67,seriesReVisit,"2018-04-04");
        dataset.addValue(211,seriesReVisit,"2018-04-05");
        dataset.addValue(11,seriesReVisit,"2018-04-06");
        dataset.addValue(7,seriesReVisit,"2018-04-07");

        this.chart = ChartFactory.createBarChart(
                "Visitor Status",//차트 제목
                "Date",//가로축 라벨
                "Visit Count",//세로축 라벨
                dataset,//데이타
                PlotOrientation.HORIZONTAL, //차트의 방향성
                true, //범례
                true, // 툴팁 텍스트
                false); //URLS

        chart.setBackgroundPaint(Color.white);
        chart.setTextAntiAlias(true);
        chart.setAntiAlias(true);
        return SUCCESS;
    }

    public JFreeChart getChart() {
        return chart;
    }

    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }
}
