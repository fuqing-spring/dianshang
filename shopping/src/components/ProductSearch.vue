<template>
  <div class="hello">
    <el-button type="primary" @click="handleAdd">创建商品</el-button>
    <el-table :data="product" stripe style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <!-- <el-table-column prop="mainPicUrl" label="image" width="180"></el-table-column> -->
       <el-table-column label="image">
        <template slot-scope="scope">
          <el-image style="width: 100px; height: 100px" :src="'http://localhost:8090/image/'+scope.row.pic"></el-image>
        </template>
      </el-table-column>
      <el-table-column prop="productName" label="Product Name" width="180"></el-table-column>
      <el-table-column prop="productCode" label="Model" width="180"></el-table-column>
      <el-table-column prop="price" label="Price" width="180"></el-table-column>
      <el-table-column prop="stockQuantity" label="Quantity" width="180"></el-table-column>
      <el-table-column prop="status" label="Status" width="180">
        <template slot-scope="scope">
          <span v-if="scope.row.status==0">UnShelve</span>
          <span v-if="scope.row.status==1">Putaway</span>
          <span v-if="scope.row.status==2">ToAudit</span>
        </template>
      </el-table-column>
      <el-table-column label="Action">
          <template slot-scope="scope">
            <el-button size="mini" type="primary" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)"></el-button>
          </template>
        </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" :total="total" :page-size="pageSize" @current-change="currentChange" ></el-pagination>
  </div>
</template>

<script>
import axios from "../api/common";
export default {
  name: "ProductSearch",
  data() {
    return {
      product: [],
      total: 0,
      pageSize: 5,
    };
  },
  methods: {
    getProduct(pageNum) {
      var search = {
        params:{
          pageNum:pageNum
        }
      }
      axios.get("/product/search",search).then(res => {
        this.product = res.data.list;
        this.total = res.data.total;
      });
    },
    handleSelectionChange(selections){

    },
    currentChange(pageNum){
      this.getProduct(pageNum);
    },
    handleAdd(){
       this.$router.push("/productcreate")
    },
    handleEdit(index,row){
      this.$router.push({name: "ProductUpdate",params:row})
    }
  },
  mounted() {
    this.getProduct();
  }
};
</script>s

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
