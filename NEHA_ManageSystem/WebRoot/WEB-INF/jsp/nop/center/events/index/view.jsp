<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/cis-tags" %>
<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
</style>

<div class="pageContent" style="padding:5px">
	<div class="panel" defH="40">
		<h1><s:property value="event.eventTitle" /></h1>
	</div>
	<div class="divider"></div>
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span><s:text name="npo.center.events.index.event.view.overview" /></span></a></li>
					<li><a href="javascript:;"><span><s:text name="npo.center.events.index.event.view.child" /></span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<div>
				<p>
					<label style="line-height:30px;"><s:text name="npo.center.events.index.event.shorttitle"/>: </label>
					<span style="margin-left:10px; line-height:30px;"><s:property value="event.eventShortTitle" /></span>
				</p>
				<p>
					<label style="line-height:30px;"><s:text name="npo.center.events.index.event.abstract"/>: </label>
					<span style="margin-left:10px; line-height:30px;"><s:property value="event.eventAbstract" /></span>
				</p>
				<p>
					<label><s:text name="npo.center.events.index.event.keyword"/>: </label>
					<span style="margin-left:10px; line-height:30px;"><s:property value="event.eventKeyword" /></span>
				</p>
				<p>
					<label><s:text name="npo.center.events.index.event.start"/>: </label>
					<span style="margin-left:10px; line-height:30px;"><s:date name="event.eventStart" format="yyyy-MM-dd" /></span>
				</p>
				<p>
					<label><s:text name="npo.center.events.index.event.exp"/>: </label>
					<span style="margin-left:10px; line-height:30px;"><s:date name="event.eventExp" format="yyyy-MM-dd" /></span>
				</p>
				<p>
					<label><s:text name="npo.center.events.index.event.status"/>: </label>
					<span style="margin-left:10px; line-height:30px;"><s:property value="event.status.aesName" /></span>
				</p>
				<p>
					<label><s:text name="npo.center.events.index.event.top"/>: </label>
					<span style="margin-left:10px; line-height:30px;"><s:if test="event.eventTop" ><s:text name="npo.center.events.index.event.top.yes" /></s:if><s:else><s:text name="npo.center.events.index.event.top.no" /></s:else></span>
				</p>
				<p>
					<label><s:text name="npo.center.events.index.event.order"/>: </label>
					<span style="margin-left:10px; line-height:30px;"><s:property value="event.eventOrder" /></span>
				</p>
				<p>
					<label><s:text name="npo.center.events.index.event.parent"/>: </label>
					<span style="margin-left:10px; line-height:30px;"><s:if test="parentEvent == null"><s:text name="npo.center.events.index.event.parent.null" /></s:if><s:else><s:property value="parentEvent.eventTitle" /></s:else></span>
				</p>
				<p>
					<label><s:text name="npo.center.events.index.event.category"/>: </label>
					<span style="margin-left:10px; line-height:30px;"><c:categorycheckbox name="event.eventCategory" value="event.eventCategory" list="categories"/></span>
				</p>
			</div>
			<div>
				<div layoutH="146" style="float:left; display:block; overflow:auto; width:240px; border:solid 1px #CCC; line-height:21px; background:#fff">
				    <ul class="tree treeFolder">
						<li><a href="javascript"><s:text name="npo.center.events.index.event.children"/></a>
							<ul>
								<li><a href="<s:property value="absolutePath" />npo/center/events/index/viewChildList.do?event.eventParent=<s:property value="eventId" />" target="ajax" rel="eventViewBox"><s:text name="npo.center.events.index.event.children.all"/></a></li>
							</ul>
						</li>
						
				     </ul>
				</div>
				<div id="eventViewBox" class="unitBox" style="margin-left:246px;">
				</div>
			</div>
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>
	
</div>