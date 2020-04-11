function addCom() {
	layer.open({
		type: 1,
		title: '发表评论',
		skin: 'layui-layer-rim', //加上边框
		area: ['420px', '240px'], //宽高
		content: $('#editor')
	});
}

