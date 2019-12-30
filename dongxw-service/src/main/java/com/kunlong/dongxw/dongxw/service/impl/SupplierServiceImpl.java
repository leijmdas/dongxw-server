package com.kunlong.dongxw.dongxw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kunlong.dongxw.dongxw.domain.Supplier;
import com.kunlong.dongxw.dongxw.dao.SupplierMapper;
import com.kunlong.dongxw.dongxw.service.SupplierService;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
/**
 * SupplierServiceImpl
 * @author generator
 * @date 2019年12月30日
 */
@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Supplier entity){
		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(Supplier entity){
		this.checkEntity(entity);
		repo.update(entity);
	}
	/**
	 * 较验实体
	 * @param entity
	 */
	public void checkEntity(Supplier entity){
	
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(FreeMarker template error:
The following has evaluated to null or missing:
==> domainEntity.pkClassName  [in template "service.impl.java.tpl" at line 44, column 34]

Tip: If the failing expression is known to be legally null/missing, either specify a default value with myOptionalVar!myDefault, or use <#if myOptionalVar??>when-present<#else>when-missing</#if>. (These only cover the last step of the expression; to cover the whole expression, use parenthessis: (myOptionVar.foo)!myDefault, (myOptionVar.foo)??

The failing instruction (FTL stack trace):
----------
==> ${domainEntity.pkClassName}  [in template "service.impl.java.tpl" at line 44, column 32]
----------

Java stack trace (for programmers):
----------
freemarker.core.InvalidReferenceException: [... Exception message was already printed; see it above ...]
	at freemarker.core.InvalidReferenceException.getInstance(InvalidReferenceException.java:98)
	at freemarker.core.EvalUtil.coerceModelToString(EvalUtil.java:382)
	at freemarker.core.Expression.evalAndCoerceToString(Expression.java:115)
	at freemarker.core.DollarVariable.accept(DollarVariable.java:76)
	at freemarker.core.Environment.visit(Environment.java:265)
	at freemarker.core.MixedContent.accept(MixedContent.java:93)
	at freemarker.core.Environment.visit(Environment.java:265)
	at freemarker.core.Environment.process(Environment.java:243)
	at freemarker.template.Template.process(Template.java:277)
	at com.pitaya.codegen.util.TemplateHelper.write2File(TemplateHelper.java:77)
	at com.pitaya.codegen.generator.ServiceClassGenerator.generate(ServiceClassGenerator.java:79)
	at com.pitaya.codegen.ui.CodeGenOptionDiag.actionPerformed(CodeGenOptionDiag.java:222)
	at javax.swing.AbstractButton.fireActionPerformed(Unknown Source)
	at javax.swing.AbstractButton$Handler.actionPerformed(Unknown Source)
	at javax.swing.DefaultButtonModel.fireActionPerformed(Unknown Source)
	at javax.swing.DefaultButtonModel.setPressed(Unknown Source)
	at javax.swing.plaf.basic.BasicButtonListener.mouseReleased(Unknown Source)
	at java.awt.Component.processMouseEvent(Unknown Source)
	at javax.swing.JComponent.processMouseEvent(Unknown Source)
	at java.awt.Component.processEvent(Unknown Source)
	at java.awt.Container.processEvent(Unknown Source)
	at java.awt.Component.dispatchEventImpl(Unknown Source)
	at java.awt.Container.dispatchEventImpl(Unknown Source)
	at java.awt.Component.dispatchEvent(Unknown Source)
	at java.awt.LightweightDispatcher.retargetMouseEvent(Unknown Source)
	at java.awt.LightweightDispatcher.processMouseEvent(Unknown Source)
	at java.awt.LightweightDispatcher.dispatchEvent(Unknown Source)
	at java.awt.Container.dispatchEventImpl(Unknown Source)
	at java.awt.Window.dispatchEventImpl(Unknown Source)
	at java.awt.Component.dispatchEvent(Unknown Source)
	at java.awt.EventQueue.dispatchEventImpl(Unknown Source)
	at java.awt.EventQueue.access$500(Unknown Source)
	at java.awt.EventQueue$3.run(Unknown Source)
	at java.awt.EventQueue$3.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(Unknown Source)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(Unknown Source)
	at java.awt.EventQueue$4.run(Unknown Source)
	at java.awt.EventQueue$4.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(Unknown Source)
	at java.awt.EventQueue.dispatchEvent(Unknown Source)
	at java.awt.EventDispatchThread.pumpOneEventForFilters(Unknown Source)
	at java.awt.EventDispatchThread.pumpEventsForFilter(Unknown Source)
	at java.awt.EventDispatchThread.pumpEventsForFilter(Unknown Source)
	at java.awt.WaitDispatchSupport$2.run(Unknown Source)
	at java.awt.WaitDispatchSupport$4.run(Unknown Source)
	at java.awt.WaitDispatchSupport$4.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.awt.WaitDispatchSupport.enter(Unknown Source)
	at java.awt.Dialog.show(Unknown Source)
	at java.awt.Component.show(Unknown Source)
	at java.awt.Component.setVisible(Unknown Source)
	at java.awt.Window.setVisible(Unknown Source)
	at java.awt.Dialog.setVisible(Unknown Source)
	at com.pitaya.codegen.ui.TableGridPanel.actionPerformed(TableGridPanel.java:106)
	at javax.swing.AbstractButton.fireActionPerformed(Unknown Source)
	at javax.swing.AbstractButton$Handler.actionPerformed(Unknown Source)
	at javax.swing.DefaultButtonModel.fireActionPerformed(Unknown Source)
	at javax.swing.DefaultButtonModel.setPressed(Unknown Source)
	at javax.swing.plaf.basic.BasicButtonListener.mouseReleased(Unknown Source)
	at java.awt.Component.processMouseEvent(Unknown Source)
	at javax.swing.JComponent.processMouseEvent(Unknown Source)
	at java.awt.Component.processEvent(Unknown Source)
	at java.awt.Container.processEvent(Unknown Source)
	at java.awt.Component.dispatchEventImpl(Unknown Source)
	at java.awt.Container.dispatchEventImpl(Unknown Source)
	at java.awt.Component.dispatchEvent(Unknown Source)
	at java.awt.LightweightDispatcher.retargetMouseEvent(Unknown Source)
	at java.awt.LightweightDispatcher.processMouseEvent(Unknown Source)
	at java.awt.LightweightDispatcher.dispatchEvent(Unknown Source)
	at java.awt.Container.dispatchEventImpl(Unknown Source)
	at java.awt.Component.dispatchEvent(Unknown Source)
	at java.awt.EventQueue.dispatchEventImpl(Unknown Source)
	at java.awt.EventQueue.access$500(Unknown Source)
	at java.awt.EventQueue$3.run(Unknown Source)
	at java.awt.EventQueue$3.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(Unknown Source)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(Unknown Source)
	at java.awt.EventQueue$4.run(Unknown Source)
	at java.awt.EventQueue$4.run(Unknown Source)
	at java.security.AccessController.doPrivileged(Native Method)
	at java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(Unknown Source)
	at java.awt.EventQueue.dispatchEvent(Unknown Source)
	at java.awt.EventDispatchThread.pumpOneEventForFilters(Unknown Source)
	at java.awt.EventDispatchThread.pumpEventsForFilter(Unknown Source)
	at java.awt.EventDispatchThread.pumpEventsForHierarchy(Unknown Source)
	at java.awt.EventDispatchThread.pumpEvents(Unknown Source)
	at java.awt.EventDispatchThread.pumpEvents(Unknown Source)
	at java.awt.EventDispatchThread.run(Unknown Source)
