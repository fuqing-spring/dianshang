<template>
  <div class="hello" style="text-align:left;width:330px">
    <el-form ref="updateProduct" :model="updateProduct" label-width="80px">
      <el-form-item label="商品名称:">
        <el-input v-model="updateProduct.productName"></el-input>
      </el-form-item>
      <el-form-item label="商品价格:">
        <el-input v-model="updateProduct.price"></el-input>
      </el-form-item>
      <el-form-item label="商品打折:">
        <el-input v-model="updateProduct.discount"></el-input>
      </el-form-item>
      <el-form-item label="商品库存量:">
        <el-input v-model="updateProduct.stockQuantity"></el-input>
      </el-form-item>
      <el-form-item label="商品积分:">
        <el-input v-model="updateProduct.rewordPoints"></el-input>
      </el-form-item>
      <el-form-item label="商品排序:">
        <el-input v-model="updateProduct.sortOrder"></el-input>
      </el-form-item>
      <el-form-item label="商品描述">
        <el-input type="textarea" v-model="updateProduct.description"></el-input>
      </el-form-item>
      <el-form-item label="商品状态">
        <el-select v-model="updateProduct.status" placeholder="请选择处理状态">
          <el-option label="下架" value="0"></el-option>
          <el-option label="上架" value="1"></el-option>
          <el-option label="待审核" value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-from-item>
        <el-upload
          ref="uploadMain"
          action
          :http-request="uploadMainImage"
          :limit="1"
          accept="image/*"
          :auto-upload="false"
          :on-change="handleOnMainChange"
          :file-list="mainFileList">
          <el-button slot="trigger" size="small" type="primary">选取主图</el-button>
          <el-button size="small" type="success" @click="handleUploadMainClick">上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
        </el-upload>上传后主图：
        <el-link type="primary">{{mainPicUrl}}</el-link>
      </el-from-item>
      <el-form-item>
        <el-upload
          ref="uploadOther"
          multiple
          action
          :http-request="uploadOtherImage"
          :limit="9"
          accept="image/*"
          :auto-upload="false"
          :on-change="handleOnOtherChange"
          :on-remove="handleOnOtherRemove"
          :file-list="otherFileList">
          <el-button slot="trigger" size="small" type="primary">选取其他图片</el-button>
          <el-button size="small" type="success" @click="handleUploadOtherClick">上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即提交</el-button>
        <el-button @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "../api/common";
export default {
  name: "ProductUpdate",

  data() {
    return {
      updateProduct: {},
      productId: "",
      selectedMainPic: "",
      mainPicUrl: "",
      selectedOtherPics: [],
      otherPicUrls: [],
      mainFileList: [],
      otherFileList: []
    };
  },
  methods: {
    getById() {
      axios
        .get("/product/getById", { params: { productId: this.productId } })
        .then(res => {
          this.updateProduct = res.data;
        });
    },
    onSubmit() {
      this.updateProduct.mainPicUrl=app.mainPicUrl;
      this.updateProduct.otherPicUrls=app.otherPicUrls;
      axios.post("/product/update", this.updateProduct).then(res => {
        if (res.data > 0) {
          alert("编辑成功!");
          this.$router.push("/productsearch");
        }
      });
    },
    cancel() {
      this.$router.push("/productsearch");
    },
    handleOnMainChange(val) {
      this.selectedMainPic = val.raw;
    },
    handleUploadMainClick() {
      var formData = new FormData();
      formData.append("image", this.selectedMainPic);

      axios
        .post("/image/upload", formData, {
          headers: {
            "Content-Type": "multipart/form-data"
          }
        })
        .then(function(response) {
          console.log(response);
          app.mainPicUrl = response.data;
          alert("上传成功");
        })
        .catch(function(error) {
          console.log(error);
          alert("上传失败");
        });
    },
    handleOnOtherChange(file, fileList) {
      console.log("fileList", fileList);

      this.selectedOtherPics = fileList;
    },
    handleOnOtherRemove(file, fileList) {
      console.log("fileList", fileList);

      this.selectedOtherPics = fileList;
    },
    handleUploadOtherClick() {
      console.log("upload other pic click");

      this.selectedOtherPics.forEach(pic => {
        var formData = new FormData();
        formData.append("image", pic.raw);

        axios
          .post("/image/upload", formData, {
            headers: {
              "Content-Type": "multipart/form-data"
            }
          })
          .then(function(response) {
            console.log(response);
            var url = response.data;
            app.otherPicUrls.push(url);
            alert("上传成功");
          })
          .catch(function(error) {
            console.log(error);
            alert("上传失败");
          });
      });
    }
  },

  mounted() {
    this.productId = this.$route.params.productId;
    console.log(this.productId);
    this.getById();
  }
};
</script>

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
