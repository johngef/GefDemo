package com.sumu.gefdemo.model;

import java.util.List;

/**
 * Created by gefufeng on 16/2/2.
 */
public class GsonFormatTest {


    /**
     * msg : 获取订单时间轴成功
     * content : [{"orderTimelineId":21,"customerId":41,"orderId":3299,"orderState":23,"content":"下单成功，等待系统确认","createdOn":"2016-02-01 10:31:01"}]
     * status : 1
     */

    private String msg;
    private int status;
    /**
     * orderTimelineId : 21
     * customerId : 41
     * orderId : 3299
     * orderState : 23
     * content : 下单成功，等待系统确认
     * createdOn : 2016-02-01 10:31:01
     */

    private List<ContentEntity> content;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setContent(List<ContentEntity> content) {
        this.content = content;
    }

    public String getMsg() {
        return msg;
    }

    public int getStatus() {
        return status;
    }

    public List<ContentEntity> getContent() {
        return content;
    }

    public static class ContentEntity {
        private int orderTimelineId;
        private int customerId;
        private int orderId;
        private int orderState;
        private String content;
        private String createdOn;

        public void setOrderTimelineId(int orderTimelineId) {
            this.orderTimelineId = orderTimelineId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public void setOrderState(int orderState) {
            this.orderState = orderState;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setCreatedOn(String createdOn) {
            this.createdOn = createdOn;
        }

        public int getOrderTimelineId() {
            return orderTimelineId;
        }

        public int getCustomerId() {
            return customerId;
        }

        public int getOrderId() {
            return orderId;
        }

        public int getOrderState() {
            return orderState;
        }

        public String getContent() {
            return content;
        }

        public String getCreatedOn() {
            return createdOn;
        }
    }
}
