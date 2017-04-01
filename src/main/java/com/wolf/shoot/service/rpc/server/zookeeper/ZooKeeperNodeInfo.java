package com.wolf.shoot.service.rpc.server.zookeeper;

import com.alibaba.fastjson.JSON;
import com.wolf.shoot.common.constant.GlobalConstants;
import com.wolf.shoot.common.util.JsonSerializer;
import com.wolf.shoot.service.rpc.server.RpcNodeInfo;

/**
 * Created by sunmosh on 2017/4/1.
 * zookeeper节点信息
 */
public class ZooKeeperNodeInfo extends RpcNodeInfo implements JsonSerializer {
    /**
     * 根节点信息
     */
    private ZooKeeperNodeBoEnum zooKeeperNodeBoEnum;

    public ZooKeeperNodeInfo(){
        super();
    }

    public ZooKeeperNodeInfo(ZooKeeperNodeBoEnum zooKeeperNodeBoEnum, String serverId, String host, String port) {
        super();
        this.zooKeeperNodeBoEnum = zooKeeperNodeBoEnum;
        setServerId(serverId);
        setHost(host);
        setPort(port);
    }

    public ZooKeeperNodeBoEnum getZooKeeperNodeBoEnum() {
        return zooKeeperNodeBoEnum;
    }

    public void setZooKeeperNodeBoEnum(ZooKeeperNodeBoEnum zooKeeperNodeBoEnum) {
        this.zooKeeperNodeBoEnum = zooKeeperNodeBoEnum;
    }

    //获取节点数据
    public String getNodePath(){
        return zooKeeperNodeBoEnum.getRootPath()  + GlobalConstants.ZooKeeperConstants.ZK_DATA_PATH + getServerId();
    }

    @Override
    public String serialize() {
        String coopreationMatchJsonString = JSON.toJSONString(this);
        return coopreationMatchJsonString;
    }

    @Override
    public void deserialize(String pack) {
        ZooKeeperNodeInfo temp = JSON.parseObject(pack, this.getClass());
        this.zooKeeperNodeBoEnum = temp.getZooKeeperNodeBoEnum();
        setServerId(temp.getServerId());
        setHost(temp.getHost());
        setPort(temp.getPort());
    }
}
