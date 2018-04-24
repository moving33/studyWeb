package com.j.ch17.spring.transactionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

//JdbcTemplate로 Dao interface를 구현한 객체
@Repository
public class OrderItemJdbcTemplateDao implements Dao<OrderItem> {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    //객체를 사용시 호출
    @PostConstruct
    private void PostConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("PostConstruct execution...");
    }

    @Override
    public long save(OrderItem orderItem) {
        String sql = "insert into ORDER_ITEM (ITEM, QTY) values (?, ?)";

        //Key Holder 키 검색을위한 인터페이스.
        // 일반적으로 JDBC 삽입 문에서 반환되는 자동 생성 키에 사용됩니다.
        // 이 인터페이스의 구현은 임의의 수의 키를 보유 할 수 있습니다.
        // 일반적으로 키는 키의 각 행에 대해 하나의 Map을 포함하는 List로 반환됩니다.
        // 자세히는 모르지만 rs처럼 db에서 쿼리문에 대한 결과를 받아서 처리 하는 interface로 추측됨.
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(sql.toString(),
                        Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, orderItem.getItem());
                pstmt.setInt(2, orderItem.getQty());
                return pstmt;
            }
        }, holder);

        Number key = holder.getKey();
        if (key != null) {
            return key.longValue();
        }
        throw new RuntimeException("No generated primary key returned");
    }

    @Override
    public OrderItem load(long id) {
        return null;
    }

    @Override
    public int update(OrderItem orderItem) {
        return 0;
    }

    @Override
    public int delete(long id) {
        return 0;
    }

    @Override
    public List loadAll() {
        //No Lamda
        /*return jdbcTemplate.query("select * from ORDER_ITEM"
                , new RowMapper<OrderItem>() {
                    @Override
                    public OrderItem mapRow(ResultSet resultSet, int i) throws SQLException {
                        return toOrderItem(resultSet);
                    }
                }
        );*/

        //Lamda
        //RowMapper ? db에서 query문 처리한 결과 값들은 Model객체로 받아오기 위한 수단
        return jdbcTemplate.query("select * from ORDER_ITEM"
                , ((resultSet, i) -> {
                    return toOrderItem(resultSet);
                }));
    }

    private OrderItem toOrderItem(ResultSet resultSet) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(resultSet.getLong("ID"));
        orderItem.setItem(resultSet.getString("ITEM"));
        orderItem.setQty(resultSet.getInt("QTY"));
        return orderItem;
    }
}
