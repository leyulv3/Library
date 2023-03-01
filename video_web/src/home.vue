<template>
    <h1>Home</h1>
    <div class="home">
        <el-carousel :interval="4000">
            <el-carousel-item v-for="(item, index) in bannerItems" :key="index">
                <img :src="item.imgUrl" alt="">
            </el-carousel-item>
        </el-carousel>
        <div class="recommend-videos">
            <div class="video-list-title">推荐视频</div>
            <ul>
                <li v-for="(video, index) in recommendVideos" :key="index">
                    <div class="video-thumb">
                        <img :src="video.thumbUrl" alt="">
                    </div>
                    <div class="video-info">
                        <div class="video-title">{{ video.title }}</div>
                        <div class="video-author">{{ video.author }}</div>
                        <div class="video-play-count">{{ video.playCount }}</div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            bannerItems: [
                { imgUrl: '/static/banner1.jpg' },
                { imgUrl: '/static/banner2.jpg' },
                { imgUrl: '/static/banner3.jpg' },
            ],
            recommendVideos: [
                {
                    thumbUrl: '/static/video1.jpg',
                    title: '视频1',
                    author: '作者1',
                    playCount: '1000次播放',
                },
                {
                    thumbUrl: '/static/video2.jpg',
                    title: '视频2',
                    author: '作者2',
                    playCount: '2000次播放',
                },
                {
                    thumbUrl: '/static/video3.jpg',
                    title: '视频3',
                    author: '作者3',
                    playCount: '3000次播放',
                },
                {
                    thumbUrl: '/static/video4.jpg',
                    title: '视频4',
                    author: '作者4',
                    playCount: '4000次播放',
                },
            ],
        };
    },
};
</script>

<style scoped>
.home {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
}

.recommend-videos {
    margin-top: 20px;
}

.video-list-title {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 10px;
}

ul {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
}

li {
    width: 24%;
    margin-bottom: 20px;
}

.video-thumb img {
    width: 100%;
}

.video-title {
    font-size: 16px;
    font-weight: bold;
    margin-top: 10px;
    margin-bottom: 5px;
}

.video-author {
    font-size: 14px;
    color: #888;
    margin-bottom: 5px;
}

.video-play-count {
    font-size: 14px;
    color: #888;
}
</style>
