<!DOCTYPE html>
<svg width="960" height="500"></svg>
<script src="https://d3js.org/d3.v4.min.js"></script>
<script>

    var svg = d3.select("svg"), // svg태그 선택
        margin = {top: 20, right: 20, bottom: 30, left: 50},// 그래프에서 margin을 정함
        width = +svg.attr("width") - margin.left - margin.right, // 전체 width에서 양쪽 마진 제외
        height = +svg.attr("height") - margin.top - margin.bottom,// 전체 heigth에서 위아래로 마진 제외
        g = svg.append("g").attr("transform", "translate(" + margin.left + "," + margin.top + ")");
    //svg에 <g>태그를 넣고 속성을 넣음 <g transform="translate(50,20)">
    var parseTime = d3.timeParse("%d-%b-%y");
    //시간 파싱 함수
    var x = d3.scaleTime()
        .rangeRound([0, width]);
    //x축은 시간값 범위 0~width
    var y = d3.scaleLinear()
        .rangeRound([height, 0]);
    //y축은 linear 순차적인 값, 범위 height~0
    //y축은 좌상단이 (0,0)이고 y값이 증가할수록 밑으로 내려가도록 그리기때문
    var line = d3.line()
        .x(function(d) { return x(d.date); })
        .y(function(d) { return y(d.close); });
    //d3.line()으로 선을 그리는데 x값은 콜백으로 x(데이터.date값), y값은 y(데이터.close값)
    //d3.tsv로 tsv파일을 읽을 수 있음
    d3.tsv("data.tsv", function(d) {
        d.date = parseTime(d.date);
        d.close = +d.close;
        return d;
    }, function(error, data) {
        if (error) throw error;
//d3.extent는 [최소,최대] 시작과 끝 직선 어디만큼 그릴지를 리턴
//domain은 입력 값의 구간, range는 출력 값의 범위
        x.domain(d3.extent(data, function(d) { return d.date; }));
        y.domain(d3.extent(data, function(d) { return d.close; }));

//aixs는 x축선과 y축선을 그리기위한 용도다.
//x축
        g.append("g")
            .attr("transform", "translate(0," + height + ")")
            .call(d3.axisBottom(x))
            .select(".domain")
            .remove();
//y축
        g.append("g")
            .call(d3.axisLeft(y))
            .append("text")
            .attr("fill", "#000")
            .attr("transform", "rotate(-90)")
            .attr("y", 6)
            .attr("dy", "0.71em")
            .attr("text-anchor", "end")
            .text("Price ($)");
//데이터선
        g.append("path")
            .datum(data)
            .attr("fill", "none")
            .attr("stroke", "steelblue")
            .attr("stroke-linejoin", "round")
            .attr("stroke-linecap", "round")
            .attr("stroke-width", 1.5)
            .attr("d", line);
    });

</script>
